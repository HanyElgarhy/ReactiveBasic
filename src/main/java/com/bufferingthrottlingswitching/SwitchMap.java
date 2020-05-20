package com.bufferingthrottlingswitching;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SwitchMap {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source=Observable.just("Hany","Tom","Jennifer")
                .concatMap(
                        e-> Observable.just(e)
                        .delay(
                                ThreadLocalRandom.current().nextInt(1000), TimeUnit.SECONDS
                        )
                );
        Observable.interval(2,TimeUnit.SECONDS)
                .switchMap(s-> source.doOnDispose(
                        ()-> System.out.println("Disposing and starting again")
                )).subscribe(System.out::println);
        Thread.sleep(10000);
    }
}

package com.replayandcaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class  Replaying {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();
        observable.subscribe(e-> System.out.println("Observer 1 : "+e));
        Thread.sleep(5000);
        observable.subscribe(e-> System.out.println("Observer 2 : "+e));
        Thread.sleep(5000);
    }
}

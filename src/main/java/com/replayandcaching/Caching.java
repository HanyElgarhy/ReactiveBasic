package com.replayandcaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Caching {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Long> cache = Observable.interval(1, TimeUnit.SECONDS)
                .cache();
        cache.subscribe(e-> System.out.println("Source 1 : "+e ));
        Thread.sleep(5000);
        cache.subscribe(e-> System.out.println("Source 2 : "+e));
        Thread.sleep(5000);
    }
}

package com.bufferingthrottlingswitching;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Buffer {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1,20)
                .buffer(2)
                .subscribe(System.out::println);
        System.out.println("==========================================================");
        Observable.range(1,20)
                .buffer(2,2)
                .subscribe(System.out::println);
        System.out.println("==========================================================");
        Observable<Long> obs =Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(1,TimeUnit.SECONDS)
                .buffer(obs)
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}

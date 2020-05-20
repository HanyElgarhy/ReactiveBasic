package com.concurrencyandparallelization;

import io.reactivex.rxjava3.core.Observable;

public class Concurrency {
    public static void main(String[] args) {
        //emission is sequential in 1 thread
        Observable source0 =Observable.create(e->{e.onNext("Hello0");
        e.onNext("RXJAVA");});
        source0.subscribe(e-> System.out.println("Observer 00 is "+e+" Thread is :"+Thread.currentThread().getName()));
        source0.subscribe(e-> System.out.println("Observer 01 is "+e+" Thread is :"+Thread.currentThread().getName()));

        System.out.println("=========================================================");
        //emission is sequential in 2 different thread
        Observable<String> source=Observable.create(
                e->{
                    new Thread(() -> {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                    }
                    ).start();
                }
        );
        source.subscribe(e-> System.out.println("Observer 1 is : "+e+" Thread is "+Thread.currentThread().getName()));
        source.subscribe(e-> System.out.println("Observer 2 is : "+e+" Thread is "+Thread.currentThread().getName()));


    }
}

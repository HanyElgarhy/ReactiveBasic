package com.flowableandbackpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Backpressure {
    public static void main(String[] args) {
        Observable.range(1,100000)
                .map(e->{
                    System.out.println("Produced item is : "+e+" Thread is : "+ Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(e->{
                    Thread.sleep(100);
                    System.out.println("Consumed item is : "+e+ " Thread is : "+ Thread.currentThread().getName());
                });
    }
}

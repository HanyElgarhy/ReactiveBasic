package com.basics;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

//Connectable observable
public class HotObservable {
    public static void main(String[] args) throws InterruptedException {
        @NonNull ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
        source.connect();
        source.subscribe(System.out::println);
        Thread.sleep(10000);
        source.subscribe(System.out::println);
    }
}

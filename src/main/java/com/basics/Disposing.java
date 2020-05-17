package com.basics;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

import java.util.concurrent.TimeUnit;

public class Disposing {
    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src= Observable.interval(1, TimeUnit.SECONDS);
        src.subscribe(e-> System.out.println("Observer 1 : "+e)).dispose();
        src.subscribe(e-> System.out.println("Observer 2 : "+e));
        Thread.sleep(5000);


    }

}

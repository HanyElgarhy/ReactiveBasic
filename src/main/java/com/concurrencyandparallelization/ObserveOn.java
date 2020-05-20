package com.concurrencyandparallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Hany","Kyle","Tom")
                .subscribeOn(Schedulers.computation())
                .map(e->e.toLowerCase())
                .subscribeOn(Schedulers.io())
                .filter(e->e.contains("a"))
                .subscribe(e-> System.out.println(e));
        Thread.sleep(5000);
    }
}

package com.combining.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> obs1= Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map(e->"Obs1 :"+e);
        Observable<String> obs2= Observable.interval(1, TimeUnit.MILLISECONDS).take(10)
                .map(e->"Obs2 :"+e);
        Observable.amb(Arrays.asList(obs1,obs2)).subscribe(System.out::println);
        Thread.sleep(1100);
    }
}

package com.combining.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src1= Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> src2=Observable.interval(1,TimeUnit.SECONDS);
        //Zip
        Observable.zip(src1,src2,(e1,e2) -> "Source 1 : "+e1+" Source 2 : "+e2).take(10)
                .subscribe(System.out::println);
        //Combine latest
        Observable.combineLatest(src1,src2,(e1,e2) -> "Source 1 : "+e1+" Source 2 : "+e2).take(10)
                .subscribe(System.out::println);
        Thread.sleep(20000);

    }
}

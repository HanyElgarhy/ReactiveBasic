package com.combining.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {
    public static void main(String[] args) throws InterruptedException {
        //Example of merge
        Observable<String> src1= Observable.just("Hany","Jen","Jennifer");
        Observable<String> src2=Observable.just("John","Tim");
        Observable.merge(src1,src2)
                .subscribe(e-> System.out.println(e));
        System.out.println("==========================================");
        src1.mergeWith(src2)
                .subscribe(e->System.out.println(e));
        //Example of concat
        Observable<String> src3=Observable.interval(1, TimeUnit.SECONDS).map(e->"src3 : "+e);
        Observable<String> src4=Observable.interval(1, TimeUnit.SECONDS).map(e->"src4 : "+e);
        Observable.concat(src3,src4)
                .subscribe(e-> System.out.println(e));
        Thread.sleep(20000);
    }
}

package com.basics;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        // Single
        Observable<String> source= Observable.just("Hany","John","Kyle");
        source.first("name")
                .subscribe(System.out::println);
        Single.just("Hany").subscribe(System.out::println);
        //Maybe
        Observable<String> source1=Observable.empty();
        source1.firstElement()
                .subscribe(System.out::println,e->e.printStackTrace(),()->System.out.println("Completed"));
        //Completable
        Completable completable= Completable.complete();
        completable.subscribe(()->System.out.println("Completed"));
        Completable
                .fromRunnable(()-> System.out.println("Some process executing"))
                .subscribe(()->System.out.println("The process is completed"));
    }
}

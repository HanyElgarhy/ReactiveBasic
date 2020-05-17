package com.basics;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {
        Observable<String> source =Observable.just("Black","White","Orange");
        source.subscribe(i-> System.out.println(i),Throwable::printStackTrace,()-> System.out.println("Completed"));
        System.out.println();
        source.subscribe(i-> System.out.println(i),Throwable::printStackTrace);
        System.out.println();
        source.subscribe(i-> System.out.println(i));
    }
}

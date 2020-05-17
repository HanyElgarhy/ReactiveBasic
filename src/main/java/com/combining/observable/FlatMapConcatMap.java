package com.combining.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMapConcatMap {
    public static void main(String[] args) {
        //Flat map
        List<String> list = List.of("Hello ", "Hany ","Welcome");
        Observable.fromIterable(list)
                .flatMap(e->Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
        System.out.println("===========================================================");
        //Concat Map
        Observable.fromIterable(list)
                .concatMap(e->Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}

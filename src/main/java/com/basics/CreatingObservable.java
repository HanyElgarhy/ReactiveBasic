package com.basics;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;


public class CreatingObservable {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(
                e->{
                    e.onNext(10);
                    e.onNext(12);
                    e.onNext(14);
                    e.onComplete();
                }
        );
        observable.subscribe(System.out::println);

    Observable<Integer> just= Observable.just(1,2,3);
    just.subscribe(System.out::println);
    //from a list
        List<String> list= new ArrayList<String>();
        list.add("Hany");
        list.add("John");

        Observable<String> fromIterator=Observable.fromIterable(list);
        fromIterator.subscribe(System.out::println);

        Observable<String> source= Observable.defer(
                ()->Observable.fromIterable(list)
        );
        source.subscribe(System.out::println);
        list.add("Paul");
        source.subscribe(System.out::println);

    }
}

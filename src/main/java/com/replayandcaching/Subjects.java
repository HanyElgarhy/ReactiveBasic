package com.replayandcaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Subjects {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Integer> obs1 = Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.computation());
        @NonNull Observable<Integer> obs2 = Observable.just(10, 20, 30, 40)
                .subscribeOn(Schedulers.computation());

        @NonNull PublishSubject<Object> subject = PublishSubject.create();
        obs1.subscribe(subject);
        obs2.subscribe(subject);
        subject.subscribe(e-> System.out.println("e"+e));
        //to add value to the emission onNext can be used 
        subject.onNext("Hello");
        Thread.sleep(9000);
    }
}

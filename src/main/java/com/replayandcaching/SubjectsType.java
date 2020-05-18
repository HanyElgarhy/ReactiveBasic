package com.replayandcaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.*;

import java.util.concurrent.TimeUnit;

public class SubjectsType {
    public static void main(String[] args) throws InterruptedException {
        //Publish subject
        System.out.println("=================Publish subject ========================");
        @NonNull PublishSubject<Object> publishSubject = PublishSubject.create();
        publishSubject.subscribe(e-> System.out.println(" subscriber 1 publish subject : "+e));
        publishSubject.onNext("a");
        publishSubject.onNext("b");
        publishSubject.onNext("c");
        publishSubject.subscribe(e-> System.out.println(" subscriber 2 publish subject : "+e));
        publishSubject.onNext("d");
        publishSubject.onNext("e");
        //Replay subject
        System.out.println("=================Replay subject ========================");
        @NonNull ReplaySubject<Object> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(e-> System.out.println(" subscriber 1 Replay subject : "+e));
        replaySubject.onNext("a");
        replaySubject.onNext("b");
        replaySubject.onNext("c");
        replaySubject.subscribe(e-> System.out.println(" subscriber 2 Replay subject : "+e));
        replaySubject.onNext("d");
        replaySubject.onNext("e");
        //Behaviour subject
        System.out.println("=================Behaviour subject ========================");
        @NonNull BehaviorSubject<Object> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.subscribe(e-> System.out.println(" subscriber 1 Behaviour subject : "+e));
        behaviorSubject.onNext("a");
        behaviorSubject.onNext("b");
        behaviorSubject.onNext("c");
        behaviorSubject.subscribe(e-> System.out.println(" subscriber 2 Behaviour subject : "+e));
        behaviorSubject.onNext("d");
        behaviorSubject.onNext("e");
        //Async subject
        System.out.println("=================Async subject ========================");
        @NonNull AsyncSubject<Object> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(e-> System.out.println(" subscriber 1 Async subject : "+e));
        asyncSubject.onNext("a");
        asyncSubject.onNext("b");
        asyncSubject.onNext("c");
        asyncSubject.subscribe(e-> System.out.println(" subscriber 2 Async subject : "+e));
        asyncSubject.onNext("d");
        asyncSubject.onNext("e");
        asyncSubject.onComplete();
        //Unicast
        System.out.println("=================Unicast==================================");
        @NonNull UnicastSubject<Object> unicastSubject = UnicastSubject.create();
        Observable.interval(500, TimeUnit.MILLISECONDS).subscribe(unicastSubject);
        Thread.sleep(2000);
        unicastSubject.subscribe(e-> System.out.println("Subscriber 1 : "+e));
        Thread.sleep(2000);
    }
}

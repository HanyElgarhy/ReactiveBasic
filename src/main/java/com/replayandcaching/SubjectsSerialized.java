package com.replayandcaching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectsSerialized {
    public static void main(String[] args) {
        PublishSubject<String> subject=PublishSubject.create();
        @NonNull Subject<String> serialized = subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e-> System.out.println("Observer 2 : "+ e));
        serialized.onNext("Hello ");
        serialized.onComplete();
        serialized.onNext("final ");

    }
}

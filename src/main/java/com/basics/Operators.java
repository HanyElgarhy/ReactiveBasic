package com.basics;

import io.reactivex.rxjava3.core.Observable;

public class Operators {
    public static void main(String[] args) {
        Observable.just(1,2,3,5,6,9)
                .filter(e->e>5)
                .sorted()
                .subscribe(e-> System.out.println("bigger than 5 : "+e));
    }
}

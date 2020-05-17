package com.operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRange;

import java.util.List;

public class OperatorsInAction {
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(1,"Hany",10000,1),
                new Employee(2,"John",20000,2),
                new Employee(3,"Kyle",30000,4),
                new Employee(4,"Jen",40000,3),
                new Employee(5,"Simon",50000,6),
                new Employee(6,"Joanne",50000,7)
        );
        obs.filter(e->e.getRating()>4)
                .sorted((e1,e2)->Double.compare(e1.getRating(),e2.getRating()))
                .map(e->e.getName())
                .take(3)
                .subscribe(System.out::println);
        List<Integer> expenses=List.of(1,2,3,4,5,6,99,7,8,9);
        Observable.fromIterable(expenses)
                .scan((a,b)->a+b)
                .subscribe(System.out::println);
        System.out.println("========================================");
        Observable.fromIterable(expenses)
                .reduce((a,b)->a+b)
                .subscribe(System.out::println);
    }
}

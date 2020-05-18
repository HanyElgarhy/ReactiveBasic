package com.combining.observable;

import com.operators.Employee;
import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(1,"Hany",10000,1),
                new Employee(2,"John",20000,2),
                new Employee(3,"Kyle",30000,2),
                new Employee(4,"Jen",40000,3),
                new Employee(5,"Simon",50000,6),
                new Employee(6,"Joanne",50000,7)
        );
        obs.groupBy(e->e.getRating())
                .flatMapSingle(e->e.toMultimap(key->e.getKey(),employee -> employee.getName()))
                .subscribe(System.out::println);
    }
}

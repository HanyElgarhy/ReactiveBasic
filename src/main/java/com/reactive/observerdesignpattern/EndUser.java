package com.reactive.observerdesignpattern;

public class EndUser implements Observer{

    String name;

    public EndUser(String name, SubjectLibrary subject) {
        subject.subscribeObserver(this);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(String available) {
        System.out.println("Hello "+name+ "We are glad to notify you that the book is available "+available);
    }
}

package com.reactive.test;

public class CallBackDemo {
    public static void main(String[] args) {
        System.out.println("Main thread is running ");

    }
    public void runningAssync(){
        System.out.println("A running separate thread");
    }
}

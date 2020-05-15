package com.reactive.test;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running ");
        Runnable r = new Runnable() {
            public void run() {
                new CallBackDemo().runningAssync(new CallBack() {

                    public void pushData(String data) {
                        System.out.println("Callback data "+data);
                    }
                    public void pushComplete() {
                        System.out.println("Callback done !");
                    }
                    public void pushError(Exception ex) {
                        System.out.println("Callback Error Called got an exception :"+ex);
                    }
                });
            }
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(2000);
        System.out.println("Main thread completed");

    }
    public void runningAssync(CallBack callBack){
        System.out.println("A running separate thread");
        sleep(1000);
        //CallBack.call() is the pull way
        //callBack.call();
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");
        callBack.pushError(new RuntimeException("oupssssssss"));
        callBack.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.reactive.test;

public interface CallBack {
    void pushData(String data);
    void pushComplete();
    void pushError(Exception ex);
    //Below is the pull
    //void call();
}

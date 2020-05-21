package com.stream;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        Stream.iterate(0,integer -> integer-1)
                .limit(20)
                .forEach(System.out::println);
        Stream.generate(()->"Hello")
                .forEach(System.out::println);
        Stream.generate(new Random():: nextInt).forEach(System.out::println);
    }
}

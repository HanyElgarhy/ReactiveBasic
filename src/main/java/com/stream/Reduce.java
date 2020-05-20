package com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        //reduce
        int sum=Stream.of(1,2,3,4)
                .parallel()
                .reduce(0,(a, b)->(a+b));
        //intermediate operation are lazy mean it get applied when terminal operation is done
        //peek can be used to track the stream takes a consumer
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> integerStream = list.stream().map(e -> e * e).peek(System.out::println).filter(e -> e > 4);
        Collect(integerStream);
    }

    private static void Collect(Stream<Integer> integerStream) {
        System.out.println("finish");
        integerStream.collect(Collectors.toList());
    }
}

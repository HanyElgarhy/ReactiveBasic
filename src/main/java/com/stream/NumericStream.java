package com.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        OptionalDouble average = list.stream().mapToInt(e -> e).average();

        IntStream intStream =IntStream.of(1,2,3,4,5);
        //to get the object version (Boxed version) i can use .boxed()
        Stream<Integer> boxed = intStream.boxed();
        //methods sum, min, max, average
        OptionalDouble average1 = intStream.average();
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        int sum = intStream.sum();
        OptionalInt min = intStream.min();
        OptionalInt max = intStream.max();


    }
}

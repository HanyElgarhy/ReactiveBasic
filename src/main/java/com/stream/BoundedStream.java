package com.stream;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class BoundedStream {
    public static void main(String[] args) {
        Map<Integer,String> map= Map.of(1,"one ",2,"two",3,"Three");
        map.entrySet().stream();
        map.values().stream();
        map.keySet().stream();
        Integer [] integersArray={1,2,3,4,5};
        Stream<Integer> integerStream = Arrays.stream(integersArray);
        //more flexible way to build stream
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
    }
}

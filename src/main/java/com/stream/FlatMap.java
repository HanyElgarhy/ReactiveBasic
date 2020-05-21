package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) throws IOException {
        Stream<String> a = Stream.of("Hany", "Kyle");
        Stream<String> b = Stream.of("Montreal", "Canada");
        Stream<Stream<String>> streamofstream = Stream.of(a, b);

        streamofstream.flatMap(e->e)
                .forEach(System.out::println);

        Path path= Paths.get("C:\\Users\\Hany\\Desktop\\Java\\Reactive Basic\\src\\main\\resources\\input.txt");
        Stream<String> lines = Files.lines(path);
        lines.flatMap(e-> Arrays.stream(e.split(" "))).collect(Collectors.toList()).forEach(System.out::println);
    }
}


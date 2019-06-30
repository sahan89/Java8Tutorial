package com.sahan.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("d2", "a2", "b1", "b3", "c");

        testMethod(stringList);
    }

    private static void testMethod(List<String> stringList) {
        Supplier<Stream<String>> streamSupplier =
                () -> stringList
                        .stream()
                        .filter(s -> s.startsWith("a"));

        boolean b1 = streamSupplier.get().anyMatch(s -> true);
        boolean b2 = streamSupplier.get().noneMatch(s -> true);

        System.out.println("-->> " + b1);
        System.out.println("-->> " + b2);
    }
}

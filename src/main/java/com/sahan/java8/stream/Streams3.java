package com.sahan.java8.stream;

import java.util.stream.IntStream;

public class Streams3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }

        System.out.println("------------------------------------------");
        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 1)
                        System.out.println(i);
                });

        System.out.println("------------------------------------------");
        IntStream.range(0,10)
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);
    }
}

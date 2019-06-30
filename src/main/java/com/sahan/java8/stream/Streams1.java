package com.sahan.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Streams1 {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc1");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // filtering
        System.out.println("---------- filtering ----------");
        stringCollection
                .stream()
                .filter((f) -> f.startsWith("a"))
                .forEach(System.out::println);

//       ---------- filtering ----------
//        aaa2, aaa1

        // sorting
        System.out.println("---------- sorting ----------");
        stringCollection
                .stream()
                .sorted()
                .filter((f) -> f.startsWith("a"))
                .forEach(System.out::println);

//        ---------- sorting ----------
//        aaa1, aaa2

        // mapping
        System.out.println("---------- mapping ----------");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

//        ---------- mapping ----------
//        DDD2, DDD1, CCC1, BBB3, BBB2, BBB1, AAA2, AAA1

        System.out.println("---------- matching ----------");
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((a) -> a.startsWith("a"));

        System.out.println("anyStartsWithA -->> " + anyStartsWithA);
//        anyStartsWithA -->> true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((a) -> a.startsWith("a"));

        System.out.println("allStartsWithA -->> " + allStartsWithA);
//        allStartsWithA -->> false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((z) -> z.startsWith("z"));

        System.out.println("noneStartsWithZ -->> " + noneStartsWithZ);
//        noneStartsWithZ -->> true

        // counting
        System.out.println("---------- counting ----------");
        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println("startsWithB -->> " + startsWithB);
//        startsWithB -->> 3

//        reducing
        Optional<String> reduce = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduce.ifPresent(System.out::println);
//        aaa1#aaa2#bbb1#bbb2#bbb3#ccc1#ddd1#ddd2
    }
}

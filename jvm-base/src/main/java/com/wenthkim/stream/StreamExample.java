package com.wenthkim.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream Api的使用
 */
public class StreamExample {


    public static void main(String[] args) {

       // flatMapApi();
      //  limitApi();
      //  peekApi();

        anyMatch();

    }


    public static void anyMatch() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

      //  boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
        boolean anyMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
        System.out.println(anyMatch);
    }




    public static void peekApi() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");

        Stream<String> stream = stringList.stream();

        Stream<String> streamPeeked = stream.peek((value) -> {
            System.out.println("value");
        });
    }

    public static void limitApi() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        Stream<String> stream = stringList.stream();
        stream
                .limit(2)
                .forEach( element -> { System.out.println(element); });
    }


    public static void distinct() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        Stream<String> stream = stringList.stream();

        List<String> distinctStrings = stream
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctStrings);
    }

    public static void mapApi() {
        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");

        Stream<String> stream = items.stream();

        //流用完会关掉
        long count = stream.map(value -> value.toLowerCase()).count();
        System.out.println("count:"+count);

        // stream.map(value -> value.substring(1)).forEach( a -> System.out.println(a));

        //保持流操作
        Stream<String> stream1 = stream
                .map((value) -> { return value.toLowerCase(); })
                .map((value) -> { return value.toUpperCase(); })
                .map((value) -> { return value.substring(0,3); });

        stream1.forEach( a -> System.out.println(a));

    }


    public static void flatMapApi() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
                .forEach((value) -> System.out.println(value))
        ;
    }


}

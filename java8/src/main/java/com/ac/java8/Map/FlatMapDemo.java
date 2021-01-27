package com.ac.java8.Map;

import com.ac.java8.stream.PersonPO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

/**
 * FlatMapDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class FlatMapDemo {
    public static void main(String[] args) {
//        String[] strings = {"Hello", "World"};
//        Arrays.asList(strings)
//                .stream()
//                .map(s -> s.split(""))
//                .flatMap(s -> Arrays.asList(s).stream())
//                .collect(Collectors.toList());


//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            list.add(i);
//        }
//
//        long beginTime = System.currentTimeMillis();
//
//        list.stream()
//                .parallel()
//                .forEach(System.out::println);
//
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("cost time:  " + (endTime - beginTime));


//        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
////                .peek(e -> System.out.println("Filtered value: " + e))
//                .peek(System.out::println)
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());
        List<List<List<String>>> listList = new ArrayList<>();
        List<List<String>> listArrayList = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("15");
        ArrayList<String> objects2 = new ArrayList<>();
        objects2.add("2");
        listArrayList.add(objects);
        listArrayList.add(objects2);
        LinkedList<Long> objects1 = objects
                .stream()
                .parallel()
//                .filter(FlatMapDemo::isRight)
                .map(Long::valueOf)
                .sorted((a1, a2) -> (int) (a2 - a1))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

//        System.out.println(objects1);
        listList.add(listArrayList);
        List<String> collect = listArrayList.stream()
                .flatMap(FlatMapDemo::addAll)
                .collect(Collectors.toList());
//        List<String> collect = listList.stream()
//                .flatMap(v -> v.stream())
//                .flatMap(v -> v.stream())
//                .collect(Collectors.toList());
//        System.out.println(collect);


//        List<PersonPO> stringList = new ArrayList<>();
//        stringList.add(new PersonPO(2, "张三"));
//        stringList.add(new PersonPO(3, "张三1"));
//        stringList.add(new PersonPO(4, "张三"));
////        Map<String, Long> collect1 = stringList
//                .stream()
//                .collect(Collectors.groupingBy(PersonPO::getName, Collectors.counting()));
//
//        Map<String, List<PersonPO>> collect = stringList
//                .stream()
//                .collect(Collectors.groupingBy(PersonPO::getName));
////                .collect(Collectors.groupingBy(PersonPO::getName, Collectors.groupingBy(PersonPO::getId)));
//        System.out.println(collect);
    }

    public static Stream<String> addAll(List<String> strings) {
//        ArrayList<String> strings1 = new ArrayList<>();
//        strings1.addAll(strings);
//        return Stream.of(strings);
        Stream<String> stream = Collections.unmodifiableList(strings).stream();
//        Stream<String> stream1 = strings.stream();
        return stream;

    }

    public static boolean isRight(String num) {
        return num.contains("1");

    }
}
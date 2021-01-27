package com.ac.java8.advancehandle;

import com.ac.java8.domain.model.Student;
import com.ac.java8.utils.TimeUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AdvanceHandleStream
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class AdvanceHandleStream {
    private final static List<Student> studentList = new ArrayList<>();

    public static void init() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(Long.valueOf(i / 2));
            Date randomBirthday = TimeUtil.plusDays(new Date(), i);
            student.setBirthday(randomBirthday);
            String randomName = RandomStringUtils.random(6, true, true);
            student.setName(randomName);
            studentList.add(student);
        }
    }


    public static void main(String[] args) {
        init();
        test();
//        peek();
//        parallel();
    }

    private static void test() {
        List<Student> studentListSortedAndNoduplicated = studentList
                .stream()
                .filter(AdvanceHandleStream::isNull)
//                .filter(Objects::nonNull)
//                .sorted(Comparator.comparing(Student::getBirthday).reversed())
                .sorted((a1, a2) -> {
                    return (int) (a1.getId() - a2.getId());
                })
                .filter(distinctKey(Student::getId))
                .collect(Collectors.toList());
    }

    public static boolean isNull(Object o) {
        return o != null;
    }

    private static void peek() {
        List<Student> collect = studentList
                .stream()
                .peek(student -> student.setName("1"))
                .collect(Collectors.toList());
    }

    private static void parallel() {
        Stream<Student> stream = studentList
                .stream();
        boolean parallel = stream.isParallel();
        System.out.println(parallel);
        Stream<Student> parallel1 = stream.parallel();
        System.out.println(stream.isParallel());
        stream.forEach(System.out::println);
    }

//    private static <T> Predicate<T> distinctKey(Function<? super T, Object> keyExtractor) {
//        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
//        return s -> seen.putIfAbsent(keyExtractor.apply(s), Boolean.TRUE) == null;
//    }

    private static <T> Predicate<T> distinctKey(Function<? super T, Object> keyExtractor) {
        Set seen = new HashSet<>();
        return s -> seen.add(keyExtractor.apply(s));
    }
}

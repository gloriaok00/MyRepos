package com.example.demo.pingshi.java8stream.s3;

import com.example.demo.pingshi.rest.Person;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

/**
 * @description
 * @date 2022/12/8 01:26
 */

public class S3 {

    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);

        Stream<String> stream = Stream.of("This", "is", "a", "test");
        Map<String, Integer> map = stream.collect(Collectors.toMap(identity(), String::length));
        map.entrySet().stream().forEach(xx -> System.out.println("键:" + xx.getKey() + ",值:" + xx.getValue()));

        Person p1 = new Person("x2", "19");
        Person p2 = new Person("x1", "19");
        Person p3 = new Person("x3", "1");
        List<Person> list = Arrays.asList(p1, p2, p3);
        taskMap(list).forEach((k, v) -> {
            System.out.println("键:" + k);
            System.out.println("值:" + v.toString());
        });

    }

    private static Map<String, Person> taskMap(List<Person> tasks) {
        return tasks.stream().collect(Collectors.toMap(Person::getAge, identity(), (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    @Test
    public void test14() {
        Map<String, Integer> m1 = ImmutableMap.of("a", 2, "b", 3);
        Map<String, Integer> m2 = ImmutableMap.of("a", 3, "c", 4);

        Map<String, Integer> mx = Stream.of(m1, m2)
                .map(Map::entrySet)          // converts each map into an entry set
                .flatMap(Collection::stream) // converts each set into an entry stream, then
                // "concatenates" it in place of the original set
                .collect(
                        Collectors.toMap(        // collects into a map
                                Map.Entry::getKey,   // where each entry is based
                                Map.Entry::getValue, // on the entries in the stream
                                Integer::max         // such that if a value already exist for
                                // a given key, the max of the old
                                // and new value is taken
                        )
                );
        mx.entrySet().forEach(ee -> {
            System.out.println("键:" + ee.getKey() + ",值:" + ee.getValue());
        });
    }

}

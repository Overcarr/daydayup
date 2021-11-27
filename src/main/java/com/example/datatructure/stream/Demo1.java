package com.example.datatructure.stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        // 构建一个 Person 集合
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Set<Person> friends = persons
                .stream()
                .filter(s -> s.name.startsWith("P"))
                .collect(Collectors.toSet());

        Map<Integer, List<Person>> collect = persons
                .stream()
                .collect(Collectors.groupingBy(s -> s.getAge()));

        collect.forEach((age,p) -> System.out.println("key:"+age+" "+"vaule:"+p));

        Integer sumAge = persons
                .stream()
                .collect(Collectors.summingInt(p -> p.getAge()));

        System.out.println("总年龄:"+sumAge);

        Double collect1 = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println(collect1);

        String s = persons
                .stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(" and ", " in sad ", " end "));

        System.out.println(s);


        Map<Integer, String> collect2 = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2
                ));

        collect2.forEach((k,v)-> System.out.println(k+"  "+v));


        persons
                .stream()
                .reduce((p1,p2) ->p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);

    }
}


@Data
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}




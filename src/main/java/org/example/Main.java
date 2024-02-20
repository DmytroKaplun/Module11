package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> nameList = List.of("Alex", "Chris", "Ivan", "Peter", "Bob", "Oleg", "Dmytro");
        //1 task
//        String oddName = nameToString(nameList);
//        System.out.println(oddName);
        //2 task
//        List<String> sortedNameList = sortName(nameList);
//        System.out.println(sortedNameList);
        //3 task
        String[] stringArray = {"1, 2, 0", "4, 5"};
        String result = Arrays.stream(stringArray)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);
        //4 task
//        long a = 25214903917L;
//        long c = 11L;
//        long m = 2^48L;
//        Stream<Long> stream = generateRandom(a, c, m);
//        stream.limit(10).forEach(System.out::println);
        //5 task
//        Stream<String> stream1 = Stream.of("A", "B", "C", "D");
//        Stream<String> stream2 = Stream.of("1", "2", "3", "4", "5", "6");
//        Stream<String> resStream = zip(stream2, stream1);
//        resStream.forEach(System.out::println);

    }

    public static String nameToString(List<String> nameList) {
        return nameList.stream()
                .filter(name -> (nameList.indexOf(name)+1)%2 != 0)
                .map(name -> (nameList.indexOf(name)+1) + ". " + name)
                .collect(Collectors.joining(", "));
    }

    public static List<String> sortName(List<String> nameList) {
        return nameList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static Stream<Long> generateRandom(long a, long c, long m) {
        long seed = 0;
        return Stream.iterate(seed, i -> ((i + 1) * a + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secStr = second.iterator();
        return first.flatMap(str -> secStr.hasNext() ? Stream.of(str, secStr.next()) : Stream.empty());
    }

}
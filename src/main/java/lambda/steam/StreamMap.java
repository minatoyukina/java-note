package lambda.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> collect = Dish.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(collect);

        String[] words = {"GoodBye", "World"};
        List<Stream<String>> collect1 = Arrays.stream(words).map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        List<String> collect2 = Arrays.stream(words).map(String::toUpperCase).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        collect1.forEach(System.out::print);
        System.out.println();
        collect2.forEach(System.out::print);
        System.out.println();

        Integer[] integers = {1, 2, 3, 4};
        Integer reduce = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}

interface Test{
    boolean equals(Object obj);
    String toString();
}

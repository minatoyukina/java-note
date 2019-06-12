package lambda.steam;

import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 4, 6, 3);
        List<Integer> list2 = Arrays.asList(11, 18, 14);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        list1.stream().filter(x -> x > 2).reduce((x, y) -> x + y).ifPresent(System.out::println);

        Arrays.stream("helloWorld".split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(s -> System.out.print(s + " "));

        System.out.println();
        lists.stream().flatMap(Collection::stream).forEach(s -> System.out.print(s + " "));
    }
}

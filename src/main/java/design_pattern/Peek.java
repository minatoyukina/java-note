package design_pattern;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Peek {
    public static void main(String[] args) {
        List<Integer> result = Stream.of(2, 3, 4, 5, 6, 7, 8, 9)
                .peek(x -> System.out.println("taking from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(5)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());
        System.out.println(result);

    }
}

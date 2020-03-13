package leetcode._22;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(2));
    }

    private List<String> generateParenthesis(int n) {
        List<List<String>> list = new ArrayList<>();
        IntStream.range(0, 2 * n).forEach(s -> list.add(Arrays.asList("(", ")")));

        return list.stream().reduce((x, y) -> x.stream().map(a -> y.stream().map(b -> a + b))
                .flatMap(t -> t).collect(Collectors.toList())).orElse(new ArrayList<>())
                .stream().filter(leetcode._20.Demo01::isValid).collect(Collectors.toList());
    }
}

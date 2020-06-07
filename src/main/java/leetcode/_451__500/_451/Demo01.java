package leetcode._451__500._451;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("abba"));
    }

    private String frequencySort(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((x, y) -> (int) (y.getValue() - x.getValue()))
                .map(t -> LongStream.range(0, t.getValue()).mapToObj(i -> String.valueOf(t.getKey())))
                .flatMap(Function.identity())
                .reduce((x, y) -> x + y).orElse("");
    }

}

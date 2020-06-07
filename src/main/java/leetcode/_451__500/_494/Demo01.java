package leetcode._451__500._494;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));
    }

    private int findTargetSumWays(int[] nums, int S) {

        return (int) Arrays.stream(nums)
                .boxed()
                .map(x -> Arrays.asList(x, -x))
                .collect(Collectors.toList())
                .stream()
                .reduce((a, b) -> a
                        .stream()
                        .map(i -> b.stream().map(j -> i + j))
                        .flatMap(t -> t)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>())
                .stream()
                .filter(s -> s == S)
                .count();
    }

}

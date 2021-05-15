package leetcode._1101__1150._1128;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numEquivDominoPairs(new int[][]{
                {1, 2}, {2, 1}, {3, 4}, {5, 6}
        }));
    }

    private int numEquivDominoPairs(int[][] dominoes) {
        return Arrays.stream(dominoes)
                .peek(Arrays::sort)
                .map(s -> s[0] + "" + s[1])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
                .map(s -> s * (s - 1) / 2).reduce(0L, Long::sum).intValue();
    }

}
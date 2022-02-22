package leetcode._1701__1750._1725;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countGoodRectangles(new int[][]{{1, 2}}));
    }

    public int countGoodRectangles(int[][] rectangles) {
        return Arrays.stream(rectangles)
                .map(x -> Math.min(x[1], x[0])).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(0L).intValue();
    }
}
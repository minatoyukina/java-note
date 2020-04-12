package leetcode._179;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{121, 12}));
    }

    private String largestNumber(int[] nums) {
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return "0";
        return Arrays.stream(nums).boxed().sorted((x, y) -> (int) (Long.parseLong(y.toString() + x) - Long.parseLong(x.toString() + y))).map(Object::toString).reduce((a, b) -> a + b).orElse("0");
    }
}

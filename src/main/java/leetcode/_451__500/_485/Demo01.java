package leetcode._451__500._485;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 0, 1, 1, 1}));
    }

    private int findMaxConsecutiveOnes(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) sb.append(num);
        return Arrays.stream(sb.toString().split("0+")).max(Comparator.comparingInt(String::length)).orElse("").length();
    }

}

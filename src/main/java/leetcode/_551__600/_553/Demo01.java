package leetcode._551__600._553;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(optimalDivision(new int[]{1000, 100, 10, 2}));
    }

    public String optimalDivision(int[] nums) {
        String num = String.valueOf(nums[0]);
        if (nums.length == 1) return num;
        if (nums.length == 2) return num + "/" + nums[1];
        String s = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining("/"));
        return num + "/(" + s.substring(num.length() + 1) + ")";
    }

}
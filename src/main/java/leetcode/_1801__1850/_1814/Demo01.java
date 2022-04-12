package leetcode._1801__1850._1814;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countNicePairs(new int[]{42, 11, 1, 97}));
    }

    public int countNicePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] -= Integer.parseInt(new StringBuilder(String.valueOf(nums[i])).reverse().toString());
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int MOD = (int) (1e9 + 7), ans = 0;
        for (Long value : map.values()) {
            ans += value * (value - 1) / 2 % MOD;
            ans %= MOD;
        }
        return ans;
    }

}
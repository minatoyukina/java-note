package leetcode._501__550._523;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkSubarraySum(new int[]{23, 6, 9}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 17));
        System.out.println(checkSubarraySum(new int[]{0, 0, 0, 0, 0}, 1));
        System.out.println(checkSubarraySum(new int[]{1, 1}, -1));
        System.out.println(checkSubarraySum(new int[]{5, 1, 0}, 0));
    }

    private boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return true;
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        int[] preSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(preSum[i + 1] % k);
            if (integer == null) {
                map.put(preSum[i + 1] % k, i);
            } else {
                if (Math.abs(i - integer) > 1)
                    return true;
            }

        }
        return false;
    }

}

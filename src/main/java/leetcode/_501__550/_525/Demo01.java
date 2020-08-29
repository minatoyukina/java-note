package leetcode._501__550._525;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaxLength(new int[]{1, 1, 0, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    private int findMaxLength(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, -1);
        for (int i = 0; i < nums.length; i++) {
            int tmp = 2 * preSum[i + 1] - i;
            Integer integer = map.get(tmp);
            if (integer == null) {
                map.put(tmp, i);
            } else {
                ans = Math.max(ans, i - integer);
            }
        }
        return ans;
    }

}

package leetcode._901__950._930;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }


    private int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(goal, 1);
        int[] pre = new int[nums.length + 1];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
            ans += map.getOrDefault(pre[i + 1], 0);
            int key = goal + pre[i + 1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return ans;
    }
}
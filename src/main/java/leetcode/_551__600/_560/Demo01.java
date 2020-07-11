package leetcode._551__600._560;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 3));
    }

    private int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}

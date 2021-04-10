package leetcode._501__550._532;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findPairs(new int[]{-1, -2, -3}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }

    private int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (k == 0) {
                if (value >= 2) ans++;
                continue;
            }
            int a = k + key, b = key - k;
            if (map.containsKey(a) && !set.contains(a)) ans++;
            if (map.containsKey(b) && !set.contains(b)) ans++;
            set.add(key);
        }
        return ans;
    }

}

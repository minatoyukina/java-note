package leetcode._2001__2050._2044;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countMaxOrSubsets(IntStream.rangeClosed(1, 16).toArray()));
    }

    public int countMaxOrSubsets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(nums, 0, 0, map);
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(0);
    }

    private void dfs(int[] nums, int pos, int sum, Map<Integer, Integer> map) {
        if (pos >= nums.length) return;
        for (int i = pos; i < nums.length; i++) {
            int t = sum | nums[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
            dfs(nums, i + 1, t, map);
        }
    }

}

package leetcode.lcci;

import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1624 {

    @Test
    public void test() {
        System.out.println(pairSums(new int[]{5, 6, 5, 6}, 11));
        System.out.println(pairSums(new int[]{5, 6, 5, 6}, 10));
    }

    private List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer != null && integer > 0) {
                list.add(Arrays.asList(num, target - num));
                map.put(num, integer - 1);
                continue;
            }
            map.put(target - num, map.getOrDefault(target - num, 0) + 1);
        }
        return list;
    }
}

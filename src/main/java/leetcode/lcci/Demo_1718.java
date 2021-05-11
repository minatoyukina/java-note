package leetcode.lcci;

import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1718 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9})));
    }

    private int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : small) set.add(i);
        int left = 0, right = 0, l = 0, r = -1, max = Integer.MAX_VALUE;
        while (right < big.length) {
            if (set.contains(big[right])) {
                map.put(big[right], map.getOrDefault(big[right], 0) + 1);
            }
            while (map.size() == set.size() && map.getOrDefault(big[left], 2) > 1) {
                if (map.containsKey(big[left])) map.put(big[left], map.get(big[left]) - 1);
                left++;
            }
            if (map.size() == set.size() && right + 1 - left < max) {
                max = right + 1 - left;
                l = left;
                r = right;
            }
            right++;
        }
        if (r + 1 > l) return new int[]{l, r};
        return new int[0];
    }
}

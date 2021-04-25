package leetcode._101__150._128;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int num = i;
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

}
package leetcode._401__450._403;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo03 {


    @Test
    public void test() {
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    @SuppressWarnings("unchecked")
    private boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        Set[] dp = new Set[stones.length];
        dp[0] = new HashSet();
        dp[1] = new HashSet();
        dp[1].add(1);
        for (int i = 2; i < stones.length; i++) {
            dp[i] = new HashSet();
            for (int j = i - 1; j >= 0; j--) {
                Set set = dp[j];
                for (Object o : set) {
                    int x = (int) o;
                    if (stones[i] - stones[j] == x) dp[i].add(x);
                    if (stones[i] - stones[j] == x - 1) dp[i].add(x - 1);
                    if (stones[i] - stones[j] == x + 1) dp[i].add(x + 1);
                }
            }
        }
        return !dp[stones.length - 1].isEmpty();
    }


}
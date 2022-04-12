package leetcode._1551__1600._1578;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minCost("aaabbb", new int[]{4, 9, 3, 8, 8, 9}));
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

    public int minCost(String colors, int[] neededTime) {
        int count = 0, left = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) != colors.charAt(left) || i == colors.length() - 1) {
                count += min(left, i == colors.length() - 1 && colors.charAt(i) == colors.charAt(left) ? i : (i - 1), neededTime);
                left = i;
            }

        }
        return count;
    }

    private int min(int left, int right, int[] neededTime) {
        int sum = 0, max = 0;
        for (int i = left; i <= right; i++) {
            sum += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }
        return sum - max;
    }
}
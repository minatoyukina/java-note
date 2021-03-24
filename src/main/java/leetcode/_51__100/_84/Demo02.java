package leetcode._51__100._84;

import org.junit.Test;

public class Demo02 {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        int left = 0, right = 0;
        int min = heights[0];
        while (right < heights.length) {

            if (heights[right] >= ans) {
                left = right;
                min = heights[left];
                ans = heights[right];
            } else {
                min = Math.min(min, heights[right]);
                ans = Math.max(ans, (right - left + 1) * min);
            }
            right++;
        }
        return ans;
    }
}

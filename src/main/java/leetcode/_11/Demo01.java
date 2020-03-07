package leetcode._11;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    private int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max((j - i) * Math.min(height[i], height[j]), area);
            }
        }
        return area;
    }
}

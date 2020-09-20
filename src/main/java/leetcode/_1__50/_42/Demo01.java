package leetcode._1__50._42;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    private int trap(int[] height) {
        if (height.length <= 2) return 0;
        List<Integer> peeks = new ArrayList<>();
        if (height[0] > height[1]) peeks.add(0);
        label:
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] >= height[i - 1] && height[i] >= height[i + 1]) {
                if (peeks.size() > 0 && height[i] < height[peeks.get(peeks.size() - 1)]) {
                    for (int j = i + 1; j < height.length; j++) {
                        if (height[j] > height[i]) continue label;
                    }
                }
                peeks.add(i);
            }
        }
        if (height[height.length - 1] > height[height.length - 2]) peeks.add(height.length - 1);
        int ans = 0;
        for (int i = 0; i < peeks.size() - 1; i++) {
            for (int j = peeks.get(i); j <= peeks.get(i + 1); j++) {
                int min = Math.min(height[peeks.get(i)], height[peeks.get(i + 1)]);
                ans += (min - height[j]) < 0 ? 0 : (min - height[j]);
            }
        }
        return ans;
    }
}

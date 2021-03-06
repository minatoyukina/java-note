package leetcode._50__100._55;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{4, 0, 1, 0, 4}));
    }

    private boolean canJump(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int x = i, offset = 0;
                while (x >= 0) {
                    if (nums[x] > offset) break;
                    else {
                        if (x == 0) return false;
                        offset++;
                        x--;
                    }
                }
            }
        }
        return true;
    }
}

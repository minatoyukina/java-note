package leetcode._1__50._16;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4, 3}, 2));
    }

    private int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int s = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(sum - target);
                    if (abs < s) {
                        s = abs;
                        answer = sum;
                    }
                }
            }
        }
        return answer;
    }
}

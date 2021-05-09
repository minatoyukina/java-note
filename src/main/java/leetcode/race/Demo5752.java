package leetcode.race;

import org.junit.Test;

import java.util.Stack;

public class Demo5752 {

    @Test
    public void test() {
        System.out.println(maxSumMinProduct(new int[]{2, 5, 4, 2, 4, 5, 3, 1, 2, 4}));
    }

    private int maxSumMinProduct(int[] nums) {
        Stack<Integer> left = new Stack<>(), right = new Stack<>();
        int[] l = new int[nums.length], r = new int[nums.length];
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
            l[i] = -1;
            r[i] = nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!right.isEmpty() && nums[i] < nums[right.peek()]) {
                r[right.pop()] = i;
            }
            right.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!left.isEmpty() && nums[i] < nums[left.peek()]) {
                l[left.pop()] = i;
            }
            left.push(i);
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, (pre[r[i]] - pre[l[i] + 1]) * nums[i]);
        }
        return (int) (ans % 1000000007);
    }
}

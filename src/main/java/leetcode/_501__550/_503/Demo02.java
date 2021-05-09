package leetcode._501__550._503;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    private int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[i + nums.length] = nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            while (!stack.isEmpty() && x > arr[stack.peek()]) ans[stack.pop()] = x;
            if (i < nums.length) stack.push(i);
        }
        return ans;
    }

}

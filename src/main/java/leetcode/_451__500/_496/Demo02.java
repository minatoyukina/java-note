package leetcode._451__500._496;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) map.put(stack.pop(), num);
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) ans[i] = map.getOrDefault(nums1[i], -1);
        return ans;
    }

}

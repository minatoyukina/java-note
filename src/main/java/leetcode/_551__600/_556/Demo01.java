package leetcode._551__600._556;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(nextGreaterElement(1999999999));
        System.out.println(nextGreaterElement(352));
        System.out.println(nextGreaterElement(98754));
    }

    private int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                map.put(i, stack.pop());
            }
            stack.push(nums[i]);
        }
        if (!map.isEmpty()) {
            int i = map.lastKey();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == map.get(i)) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            String collect = list.subList(i + 1, nums.length).stream().sorted().map(String::valueOf).collect(Collectors.joining());
            try {
                return Integer.parseInt(list.subList(0, i + 1).stream().map(String::valueOf).collect(Collectors.joining()) + collect);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

}

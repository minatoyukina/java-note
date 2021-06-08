package leetcode.lcof;

import org.junit.Test;

import java.util.Stack;

public class Demo31 {

    @Test
    public void test() {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(validateStackSequences(new int[]{}, new int[]{}));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int right = 0;
        for (int i : pushed) {
            stack.push(i);
            if (i == popped[right]) {
                stack.pop();
                right++;
            }
            while ((!stack.isEmpty()) && right < popped.length && stack.peek() == popped[right]) {
                stack.pop();
                right++;
            }
        }
        return right >= popped.length;
    }

}

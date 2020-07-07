package leetcode._901__950._946;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        for (int i = pushed.length - 1; i >= 0; i--) a.push(pushed[i]);
        for (int i = popped.length - 1; i >= 0; i--) b.push(popped[i]);
        label:
        while (!b.isEmpty()) {
            int x = b.pop();
            while (!a.isEmpty()) {
                if (!ans.isEmpty() && ans.peek() == x) {
                    ans.pop();
                    continue label;
                }
                ans.push(a.pop());
            }
            if (!ans.isEmpty() && ans.peek() == x) {
                ans.pop();
            }
        }
        return ans.isEmpty();
    }

}

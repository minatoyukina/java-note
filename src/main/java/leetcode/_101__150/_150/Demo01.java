package leetcode._101__150._150;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int res = 0;
                int b = stack.pop();
                int a = stack.pop();
                if (token.equals("+")) res += a + b;
                if (token.equals("-")) res += a - b;
                if (token.equals("*")) res += a * b;
                if (token.equals("/")) res += a / b;
                stack.push(res);
            }
        }
        return stack.pop();
    }
}

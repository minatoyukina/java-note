package leetcode._856;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("()(())"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    private int scoreOfParentheses(String S) {
        char[] chars = S.toCharArray();
        Stack<String> stack = new Stack<>();
        for (char c : chars)
            if (c == '(') stack.push("(");
            else {
                if (!stack.isEmpty()) {
                    String peek = stack.peek();
                    if (peek.equals("(")) {
                        stack.pop();
                        stack.push("1");
                    } else {
                        int i;
                        while (true) {
                            i = Integer.parseInt(stack.pop());
                            if (!stack.isEmpty() && !stack.peek().equals("(")) {
                                int j = Integer.parseInt(stack.pop());
                                stack.push(String.valueOf(i + j));
                            } else break;
                        }
                        stack.pop();
                        stack.push(String.valueOf(i * 2));
                    }
                }
            }
        int ans = 0;
        while (!stack.isEmpty()) ans += Integer.parseInt(stack.pop());
        return ans;
    }

}

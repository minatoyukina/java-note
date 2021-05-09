package leetcode._1__50._32;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestValidParentheses("(()(((()"));
        System.out.println(longestValidParentheses("()()()"));
        System.out.println(longestValidParentheses("()(())"));
    }

    private int longestValidParentheses(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == (')')) continue;
            int match = match(s, i);
            ans = Math.max(ans, match);
            i += match;
        }
        return ans;
    }

    private int match(String s, int index) {
        Stack<Character> stack = new Stack<>();
        int count = 0, ans = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else {
                if (stack.isEmpty()) break;
                stack.pop();
                count += 2;
                if (stack.isEmpty()) ans = Math.max(ans, count);
            }
        }
        return ans;
    }

}
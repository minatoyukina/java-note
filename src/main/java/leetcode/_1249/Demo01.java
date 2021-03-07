package leetcode._1249;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    private String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                sb.append(c);
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(c);
                }
            } else sb.append(c);
        }
        int size = stack.size();
        for (int i = sb.toString().toCharArray().length - 1; size > 0 && i >= 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                size--;
            }
        }
        return sb.toString();
    }
}

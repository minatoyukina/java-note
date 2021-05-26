package leetcode._1151__1200._1190;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("ta(())usw((((a))))"));
        System.out.println(reverseParentheses("sxmdll(q)eki(x)"));
    }

    private String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                Integer pop = stack.pop();
                sb.replace(pop, i + 1, new StringBuilder(sb.substring(pop, i + 1)).reverse().toString());
            }
        }
        return sb.toString().replace("(", "").replace(")", "");
    }

}
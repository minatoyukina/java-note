package leetcode._651__700._678;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*)(*"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

    }

    private boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        return check(s, stack);
    }

    @SuppressWarnings("all")
    private boolean check(String s, Stack<Character> stack) {
        while (s.contains("()")) s = s.replace("()", "");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            } else {
                String cs = s.substring(i + 1);
                return check(cs, (Stack<Character>) stack.clone()) ||
                        check("(" + cs, (Stack<Character>) stack.clone()) ||
                        check(")" + cs, (Stack<Character>) stack.clone());

            }
        }
        return stack.isEmpty();
    }
}

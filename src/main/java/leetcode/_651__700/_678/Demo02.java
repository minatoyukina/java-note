package leetcode._651__700._678;

import org.junit.Test;

import java.util.Stack;

public class Demo02 {

    @Test
    public void test() {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*)(*"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

    }

    private boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') star.push(i);
            else {
                if (left.isEmpty() && star.isEmpty()) return false;
                if (!left.isEmpty()) left.pop();
                else star.pop();
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) return false;
            left.pop();
            star.pop();
        }
        return left.isEmpty();
    }

}

package leetcode._201__250._227;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(calculate("2*3-4"));
        System.out.println(calculate("3+5 / 2"));
    }

    @SuppressWarnings("all")
    private int calculate(String s) {
        int off = 0;
        s = s.trim();
        Deque<Integer> deque = new LinkedList<>();
        Deque<Character> operator = new LinkedList<>();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOperator(c) || i == s.length() - 1) {
                String sub = s.substring(off, i == s.length() - 1 ? s.length() : i).trim();

                int x = sub.isEmpty() ? deque.pollLast() : Integer.parseInt(sub);
                off = i + 1;
                deque.offerLast(x);
                int next = i;
                for (int j = i + 1; j < s.length(); j++) {
                    char d = s.charAt(j);
                    if (isOperator(d) || j == s.length() - 1) {
                        next = j == s.length() - 1 ? s.length() : j;
                        break;
                    }
                }
                if (off >= s.length()) break;
                int y = Integer.parseInt(s.substring(off, next).trim());
                if (c == '*') {
                    off = next;
                    i = next - 1;
                    deque.offerLast(deque.pollLast() * y);
                } else if (c == '/') {
                    off = next;
                    i = off - 1;
                    deque.offerLast(deque.pollLast() / y);
                } else operator.offerLast(c);
            }
        }
        while (!operator.isEmpty()) {
            Character c = operator.pollFirst();
            int a = deque.pollFirst();
            int b = deque.pollFirst();
            if (c == '+') deque.offerFirst(a + b);
            else deque.offerFirst(a - b);
        }
        return deque.isEmpty() ? Integer.parseInt(s) : deque.poll();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}
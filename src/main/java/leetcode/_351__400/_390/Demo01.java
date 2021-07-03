package leetcode._351__400._390;

import org.junit.Test;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "=>" + lastRemaining(i));
        }
    }

    private int lastRemaining(int n) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        a.addAll(IntStream.rangeClosed(1, n).boxed().sorted((x, y) -> y - x).collect(Collectors.toList()));
        while (a.size() > 1 || b.size() > 1) {
            if (a.isEmpty()) {
                int i = 0;
                while (!b.isEmpty()) {
                    if (i++ % 2 != 0) a.push(b.pop());
                    else b.pop();
                }
            } else {
                int i = 0;
                while (!a.isEmpty()) {
                    if (i++ % 2 != 0) b.push(a.pop());
                    else a.pop();
                }
            }
        }
        return a.isEmpty() ? b.pop() : a.pop();
    }

}
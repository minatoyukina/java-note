package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0303 {

    @Test
    public void test() {
        StackOfPlates stack = new StackOfPlates(1);
        stack.push(7);
        stack.push(3);
        stack.push(7);
        stack.push(8);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }

    @SuppressWarnings("all")
    class StackOfPlates {

        private List<Stack<Integer>> list;
        private int cap;

        public StackOfPlates(int cap) {
            list = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap <= 0) return;
            if (list.isEmpty() || list.get(list.size() - 1).size() == cap) {
                Stack<Integer> s = new Stack<>();
                s.push(val);
                list.add(s);
            } else {
                Stack<Integer> stack = list.get(list.size() - 1);
                stack.push(val);
            }
        }

        public int pop() {
            if (list.isEmpty()) return -1;
            Stack<Integer> stack = list.get(list.size() - 1);
            if (stack.size() == 1) list.remove(list.size() - 1);
            return stack.pop();
        }

        public int popAt(int index) {
            if (index >= list.size()) return -1;
            Stack<Integer> stack = list.get(index);
            if (stack.size() == 1) list.remove(index);
            return stack.pop();
        }
    }


}

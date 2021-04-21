package leetcode.lcci;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0305 {

    @Test
    public void test() {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    @SuppressWarnings("all")
    class SortedStack {

        private Stack<Integer> stack;
        private Stack<Integer> back;


        public SortedStack() {
            stack = new Stack<>();
            back = new Stack<>();
        }

        public void push(int val) {
            while (!stack.isEmpty() && stack.peek() < val) {
                back.push(stack.pop());
            }
            stack.push(val);
            while (!back.isEmpty()) {
                stack.push(back.pop());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) stack.pop();
        }

        public int peek() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }


}

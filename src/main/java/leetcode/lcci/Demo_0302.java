package leetcode.lcci;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0302 {

    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();
        stack.pop();
        stack.top();
        stack.getMin();

    }

    @SuppressWarnings("all")
    class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) minStack.push(x);
            else minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }


}

package leetcode._201__250._232;

import org.junit.Test;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> backUp;

    @Test
    public void test() {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    public MyQueue() {
        stack = new Stack<>();
        backUp = new Stack<>();
    }


    private void push(int x) {
        while (!stack.isEmpty()) backUp.push(stack.pop());
        backUp.push(x);
        while (!backUp.isEmpty()) stack.push(backUp.pop());
    }

    private int pop() {
        return stack.pop();
    }

    private int peek() {
        return stack.peek();
    }

    private boolean empty() {
        return stack.isEmpty();
    }
}

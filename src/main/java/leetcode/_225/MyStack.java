package leetcode._225;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> backUp;

    @Test
    public void test() {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }


    public MyStack() {
        queue = new ArrayBlockingQueue<>(100);
    }


    private void push(int x) {
        queue.add(x);
    }


    private int pop() {
        int a = 0;
        backUp = new ArrayBlockingQueue<>(10);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) a = queue.poll();
            else backUp.add(queue.poll());
        }
        queue = backUp;
        return a;
    }


    private int top() {
        int a = 0;
        backUp = new ArrayBlockingQueue<>(10);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) a = queue.peek();
            backUp.add(queue.poll());
        }
        queue = backUp;
        return a;
    }

    private boolean empty() {
        return queue.isEmpty();
    }
}

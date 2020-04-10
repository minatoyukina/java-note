package leetcode._225;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@SuppressWarnings("all")
public class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> backUp;

    @Test
    public void test() {
        MyStack obj = new MyStack();
        obj.push(1);
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


    public void push(int x) {
        queue.add(x);
    }


    public int pop() {
        int a = 0;
        backUp = new ArrayBlockingQueue<>(10);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) a = queue.poll();
            else backUp.add(queue.poll());
        }
        queue = backUp;
        return a;
    }


    public int top() {
        int a = 0;
        backUp = new ArrayBlockingQueue<>(10);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) a = queue.peek();
            backUp.add(queue.poll());
        }
        queue = backUp;
        return a;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

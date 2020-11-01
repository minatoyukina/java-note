package leetcode._601__650._641;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@SuppressWarnings("all")
public class MyCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);                     // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));                         // 返回 true
        System.out.println(circularDeque.insertLast(2));                         // 返回 true
        System.out.println(circularDeque.insertFront(3));                        // 返回 true
        System.out.println(circularDeque.insertFront(4));                        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                                   // 返回 2
        System.out.println(circularDeque.isFull());                                    // 返回 true
        System.out.println(circularDeque.deleteLast());                                // 返回 true
        System.out.println(circularDeque.insertFront(4));                        // 返回 true
        System.out.println(circularDeque.getFront());                                  // 返回 4
    }

    private Queue<Integer> normal;
    private Queue<Integer> reverse;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        normal = new ArrayBlockingQueue<>(k);
        reverse = new ArrayBlockingQueue<>(k);
        size = k;
    }

    /**
     * Adds an item at the normal of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        reverse.add(value);
        while (!normal.isEmpty()) reverse.add(normal.poll());
        while (!reverse.isEmpty()) normal.add(reverse.poll());
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        return normal.add(value);
    }

    /**
     * Deletes an item from the normal of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        normal.poll();
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        while (!normal.isEmpty()) {
            if (normal.size() == 1) normal.poll();
            else reverse.add(normal.poll());
        }
        while (!reverse.isEmpty()) normal.add(reverse.poll());
        return true;
    }

    /**
     * Get the normal item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return normal.peek();
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        Integer peek = -1;
        while (!normal.isEmpty()) {
            if (normal.size() == 1) {
                peek = normal.peek();
            }
            reverse.add(normal.poll());
        }
        while (!reverse.isEmpty()) normal.add(reverse.poll());
        return peek;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return normal.size() + reverse.size() == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return normal.size() + reverse.size() == size;
    }
}

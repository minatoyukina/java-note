package leetcode._601__650._622;

@SuppressWarnings("all")
public class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        circularQueue.deQueue();
        circularQueue.enQueue(4);
        System.out.println(circularQueue.Rear());
    }

    private int size;
    private int offset;
    private int cap;
    private int[] arr;


    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.cap = k;
        arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size >= cap) return false;
        arr[(offset + size++) % cap] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        offset = offset == cap ? 0 : offset + 1;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return size == 0 ? -1 : arr[offset];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return size == 0 ? -1 : arr[(offset + size - 1) % cap];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == cap;
    }

}

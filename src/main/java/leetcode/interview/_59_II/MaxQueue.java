package leetcode.interview._59_II;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
class MaxQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return queue.stream().max(Integer::compareTo).orElse(-1);
    }

    public void push_back(int value) {
        queue.add(value);
    }

    public int pop_front() {
        Integer poll = queue.poll();
        if (poll == null) {
            return -1;
        }
        return poll;
    }
}


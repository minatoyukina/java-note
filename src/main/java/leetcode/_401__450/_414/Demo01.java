package leetcode._401__450._414;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(thirdMax(new int[]{1, 5, 4, 2, 3, 6}));
        System.out.println(thirdMax(new int[]{1, 5}));
    }

    private int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        queue.addAll(set);
        if (queue.size() < 3) return queue.peek() == null ? 0 : queue.peek();
        queue.poll();
        queue.poll();
        return queue.peek() == null ? 0 : queue.peek();
    }

}

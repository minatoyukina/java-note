package leetcode.lcof;

import org.junit.Test;

import java.util.PriorityQueue;

public class Demo45 {

    @Test
    public void test() {
        System.out.println(minNumber(new int[]{830, 8308}));
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    private String minNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((x, y) -> (x + y).compareTo(y + x));
        for (int num : nums) queue.offer(String.valueOf(num));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.poll());
        return sb.toString();
    }
}

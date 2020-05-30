package leetcode._1046;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    @SuppressWarnings({"ConstantConditions"})
    private int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) queue.add(stone);
        while (queue.size() >= 2) queue.add(queue.poll() - queue.poll());
        return queue.poll();
    }

}

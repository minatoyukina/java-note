package leetcode._1001__1050._1005;

import org.junit.Test;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) queue.add(num);
        while (k-- > 0) queue.add(-Optional.ofNullable(queue.poll()).orElse(0));
        return queue.stream().mapToInt(Integer::intValue).sum();
    }

}
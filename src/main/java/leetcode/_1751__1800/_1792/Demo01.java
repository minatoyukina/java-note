package leetcode._1751__1800._1792;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxAverageRatio(new int[][]{{13609, 17094}, {24079, 89827}}, 22159));
        System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> Long.compare((y[1] - y[0]) * (long) x[1] * (x[1] + 1), (x[1] - x[0]) * (long) y[1] * (y[1] + 1)));
        queue.addAll(Arrays.asList(classes));
        while (extraStudents-- > 0) {
            int[] poll = queue.poll();
            assert poll != null;
            poll[0]++;
            poll[1]++;
            queue.offer(poll);
        }
        return queue.stream().reduce((double) 0, (x, y) -> x + y[0] / (double) y[1], (x, y) -> x / y) / classes.length;
    }
}
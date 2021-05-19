package leetcode._1701__1750._1738;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
    }

    @SuppressWarnings("all")
    private int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i + 1][j + 1] = matrix[i][j] ^ pre[i][j + 1] ^ pre[i + 1][j] ^ pre[i][j];
                queue.offer(pre[i + 1][j + 1]);
            }
        }
        while (k-- > 1) queue.poll();
        return queue.poll();
    }

}
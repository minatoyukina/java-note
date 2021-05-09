package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1714 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 4, 5, 6, 7, 8, 10}, 4)));
        System.out.println(Arrays.toString(smallestK(new int[]{2, 3}, 1)));
    }

    @SuppressWarnings("all")
    private int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) queue.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) ans[i] = queue.poll();
        return ans;
    }
}

package leetcode._1451__1500._1471;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(getStrongest(new int[]{-7, 22, 17, 3}, 2)));
        System.out.println(Arrays.toString(getStrongest(new int[]{1, 2, 3, 4, 5}, 2)));
    }

    public int[] getStrongest(int[] arr, int k) {
        Queue<Integer> pos = new PriorityQueue<>((x, y) -> y - x);
        Queue<Integer> neg = new PriorityQueue<>(Integer::compareTo);
        Arrays.sort(arr);
        int[] ans = new int[k];
        int i = 0, m = arr[(arr.length - 1) / 2];
        for (int num : arr) {
            if (num <= m) neg.add(num);
            else pos.add(num);
        }
        while (k-- > 0) {
            if (!neg.isEmpty() && !pos.isEmpty()) {
                if (Math.abs(pos.peek() - m) >= Math.abs(neg.peek() - m)) ans[i++] = pos.poll();
                else ans[i++] = neg.poll();
            } else if (!pos.isEmpty()) ans[i++] = pos.poll();
            else if (!neg.isEmpty()) ans[i++] = neg.poll();
        }
        return ans;
    }
}
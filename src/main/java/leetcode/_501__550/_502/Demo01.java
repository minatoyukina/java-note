package leetcode._501__550._502;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        while (k-- > 0) {
            while (i < n && list.get(i)[0] <= w) queue.add(list.get(i++)[1]);
            if (queue.isEmpty()) break;
            w += queue.poll();
        }
        return w;
    }


}
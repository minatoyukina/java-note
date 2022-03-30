package leetcode._1601__1650._1606;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        int max = 0;
        TreeSet<Integer> free = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int i = 0; i < k; i++) free.add(i);
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i], end = arrival[i] + load[i];
            while (!busy.isEmpty() && busy.peek()[1] <= start) free.add(busy.poll()[0]);
            Integer ceiling = free.ceiling(i % k);
            if (ceiling == null) ceiling = free.ceiling(0);
            if (ceiling == null) continue;
            free.remove(ceiling);
            busy.add(new int[]{ceiling, end});
            max = Math.max(max, ++count[ceiling]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) if (count[i] == max) list.add(i);
        return list;
    }
}
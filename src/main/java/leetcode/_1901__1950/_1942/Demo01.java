package leetcode._1901__1950._1942;

import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(smallestChair(Common.strToArray("[[4,5],[12,13],[5,6],[1,2],[8,9],[9,10],[6,7],[3,4],[7,8]," +
                "[13,14],[15,16],[14,15],[10,11],[11,12],[2,3],[16,17]]"
        ), 1));
        System.out.println(smallestChair(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0));
        System.out.println(smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> in = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        Queue<int[]> out = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        in.addAll(Arrays.asList(times));
        out.addAll(Arrays.asList(times));
        int[] time = times[targetFriend];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= time[0]; i++) {
            set.add(i);
            while (!out.isEmpty() && out.peek()[1] == i) set.add(map.get(out.poll()[0]));
            if (i == time[0]) break;
            while (!in.isEmpty() && in.peek()[0] == i) {
                map.put(in.poll()[0], set.first());
                set.remove(set.first());
            }
        }
        return set.first();
    }

}
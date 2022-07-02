package leetcode._851__900._871;

import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minRefuelStops(100, 50, Common.strToArray("[[25,25],[50,50]]")));
        System.out.println(minRefuelStops(100, 10, Common.strToArray("[[10,60],[20,30],[30,30],[60,40]]")));
        System.out.println(minRefuelStops(1001, 11, Common.strToArray("[[10,100]]")));
    }

    private int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int times = 0, pos = 0;
        for (int i = 0; i <= stations.length; i++) {
            int next = i == stations.length ? target : stations[i][0];
            if (startFuel + pos < next && queue.isEmpty()) return -1;
            if (startFuel + pos >= target) return times;
            boolean b = startFuel + pos >= next;
            if (i != stations.length && b) queue.offer(stations[i][1]);
            while (!queue.isEmpty() && startFuel + pos <= next) {
                startFuel += queue.poll();
                times++;
            }
            if (i != stations.length && !b) queue.offer(stations[i][1]);
            if (startFuel + pos < next) return -1;
            startFuel -= next - pos;
            if (i != stations.length) pos = stations[i][0];
        }
        return times;
    }


}
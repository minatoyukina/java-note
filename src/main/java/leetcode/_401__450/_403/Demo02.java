package leetcode._401__450._403;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }


    private boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        for (int stone : stones) set.add(stone);
        int last = stones[stones.length - 1];
        Queue<Integer> index = new LinkedList<>();
        Queue<Integer> k = new LinkedList<>();
        index.offer(0);
        k.offer(1);
        while (!index.isEmpty()) {
            Integer p1 = index.poll();
            Integer p2 = k.poll();
            assert p1 != null;
            assert p2 != null;
            if (p1 == last) return true;
            if (p2 - 1 > 0 && set.contains(p1 + p2 - 1)) {
                index.offer(p1 + p2 - 1);
                k.offer(p2 - 1);
            }
            if (set.contains(p1 + p2)) {
                index.offer(p1 + p2);
                k.offer(p2);
            }
            if (p1 > 0 && set.contains(p1 + p2 + 1)) {
                index.offer(p1 + p2 + 1);
                k.offer(p2 + 1);
            }
        }
        return false;
    }


}
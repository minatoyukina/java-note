package leetcode._351__400._373;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 19));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.getKey() + x.getValue()));
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                queue.add(new Pair<>(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty() && k-- > 0) {
            Pair<Integer, Integer> pair = queue.poll();
            list.add(Arrays.asList(pair.getKey(), pair.getValue()));
        }
        return list;
    }

}
package leetcode._501__550._506;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    private String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());
        for (int i = 0; i < score.length; i++) queue.offer(new Pair<>(score[i], i));
        String[] ans = new String[score.length];
        int count = 0;
        String[] dic = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            assert poll != null;
            if (count <= 2) ans[poll.getValue()] = dic[count++];
            else ans[poll.getValue()] = String.valueOf(count++ + 1);
        }
        return ans;

    }

}
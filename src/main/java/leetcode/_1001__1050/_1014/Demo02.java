package leetcode._1001__1050._1014;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxScoreSightseeingPair(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    private int maxScoreSightseeingPair(int[] values) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) list.add(new Pair<>(values[i], i));
        list.sort((x, y) -> y.getKey() - x.getKey());
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> a = list.get(i);
            if (a.getKey() * 2 - 1 <= max) break;
            for (int j = i + 1; j < list.size(); j++) {
                Pair<Integer, Integer> b = list.get(j);
                if (b.getKey() + a.getKey() - 1 <= max) break;
                max = Math.max(max, a.getKey() + b.getKey() - Math.abs(a.getValue() - b.getValue()));
            }
        }
        return max;
    }

}
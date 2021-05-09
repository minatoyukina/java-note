package leetcode.lcci;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1606 {

    @Test
    public void test() {
        System.out.println(smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }

    private int smallestDifference(int[] a, int[] b) {
        List<Pair<Integer, Integer>> l1 = Arrays.stream(a).boxed().map(s -> new Pair<>(s, 1)).collect(Collectors.toList());
        List<Pair<Integer, Integer>> l2 = Arrays.stream(b).boxed().map(s -> new Pair<>(s, 2)).collect(Collectors.toList());
        l1.addAll(l2);
        List<Pair<Integer, Integer>> list = l1.stream().sorted(Comparator.comparingInt(Pair::getKey)).collect(Collectors.toList());
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            Pair<Integer, Integer> p1 = list.get(i);
            Pair<Integer, Integer> p2 = list.get(i - 1);
            if (p1.getValue() + p2.getValue() == 3) {
                ans = (int) Math.min((long) p1.getKey() - p2.getKey(), (long) ans);
            }
        }
        return ans;
    }
}

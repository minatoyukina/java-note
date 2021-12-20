package leetcode._451__500._475;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findRadius(
                new int[]{581030105, 557810404, 146319451, 908194298, 500782188, 657821123},
                new int[]{102246882, 269406752, 816731566, 884936716, 807130337, 578354438}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left = 0, max = IntStream.of(houses).max().orElse(0), right = (int) 1e9;
        TreeSet<Integer> set = IntStream.of(houses).boxed().collect(Collectors.toCollection(TreeSet::new));
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid, set, heaters, max)) right = mid;
            else left = mid + 1;
        }
        return left;
    }


    private boolean check(int t, TreeSet<Integer> set, int[] heaters, int max) {
        int pre = -1;
        for (int heater : heaters) {
            int left = heater - t, right = heater + t;
            if (left > max) break;
            Integer higher = set.higher(pre);
            if (higher != null && higher < left) return false;
            pre = right;
        }
        return pre >= max;
    }
}
package leetcode._501__550._539;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMinDifference(Lists.newArrayList("23:59", "00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            list.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        int n = list.size();
        list.sort(Integer::compareTo);
        int min = 24 * 60 - list.get(n - 1) + list.get(0);
        for (int i = 0; i < n - 1; i++) min = Math.min(min, list.get(i + 1) - list.get(i));
        return min;
    }

}
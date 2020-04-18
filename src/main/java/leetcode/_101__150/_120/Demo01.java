package leetcode._101__150._120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(list));
    }

    private int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> sum = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j == 0)
                    tmp.add(i == 0 ? list.get(j) : list.get(j) + sum.get(i - 1).get(j));
                else if (j == list.size() - 1)
                    tmp.add(list.get(j) + sum.get(i - 1).get(list.size() - 2));
                else
                    tmp.add(list.get(j) + Math.min(sum.get(i - 1).get(j), sum.get(i - 1).get(j - 1)));
            }
            sum.add(tmp);
        }
        return sum.get(sum.size() - 1).stream().min(Integer::compare).orElse(0);
    }
}

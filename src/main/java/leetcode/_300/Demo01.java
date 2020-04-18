package leetcode._300;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }


    private int lengthOfLIS(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.putIfAbsent(num, list);
            }
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer x = entry.getKey();
                List<Integer> y = entry.getValue();
                if (num > y.get(y.size() - 1)) map.get(x).add(num);
            }
        }
        System.out.println(map);
        return map.values().stream().max(Comparator.comparingInt(List::size)).orElse(new ArrayList<>()).size();
    }

}

package leetcode._351__400._352;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);       //arr = [1]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(9);       //arr = [1, 3]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(2);       //arr = [1, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(2);       //arr = [1, 2, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);       //arr = [1, 2, 3, 6, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

    }

    static class SummaryRanges {

        private final TreeMap<Integer, Integer> map;

        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            if (map.containsKey(val)) return;
            Integer key = map.lowerKey(val);
            if (map.containsKey(val + 1)) {
                if (key != null && map.get(key) == val - 1) map.put(key, map.get(val + 1));
                else map.put(val, map.get(val + 1));
                map.remove(val + 1);
            } else {
                if (key == null || map.get(key) < val - 1) map.put(val, val);
                else if (map.get(key) == val - 1) map.put(key, val);
            }
        }

        public int[][] getIntervals() {
            return map.entrySet().stream().map(s -> new int[]{s.getKey(), s.getValue()}).toArray(int[][]::new);
        }
    }

}
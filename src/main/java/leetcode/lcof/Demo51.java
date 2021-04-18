package leetcode.lcof;

import org.junit.Test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Demo51 {

    @Test
    public void test() {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }

    private int reversePairs(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for (int num : nums) {
            Map.Entry<Integer, Integer> entry = map.higherEntry(num);
            if (entry != null) ans += entry.getValue();
            map.put(num, map.getOrDefault(num, 0) + 1);
            NavigableMap<Integer, Integer> headMap = map.headMap(num, true);
            headMap.descendingMap().forEach((x, y) -> {
                Map.Entry<Integer, Integer> higherEntry = map.higherEntry(x);
                map.put(x, higherEntry == null ? y : higherEntry.getValue() + y);
            });
        }
        return ans;
    }
}

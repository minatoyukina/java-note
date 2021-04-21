package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1726 {

    @Test
    public void test() {
        System.out.println(computeSimilarities(new int[][]{
                new int[]{14, 15, 100, 9, 3},
                new int[]{32, 1, 9, 3, 5},
                new int[]{15, 29, 2, 6, 8, 7},
                new int[]{7, 10}
        }));
    }

    private List<String> computeSimilarities(int[][] docs) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < docs.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : docs[i]) map.put(x, map.getOrDefault(x, 0) + 1);
            for (int j = i + 1; j < docs.length; j++) {
                int sum = 0;
                int[] doc = docs[j];
                Map<Integer, Integer> count = new HashMap<>();
                for (int y : doc) {
                    if (map.containsKey(y) && map.get(y) > 0) {
                        sum++;
                        map.put(y, map.get(y) - 1);
                        count.put(y, count.getOrDefault(y, 0) + 1);
                    }
                }
                count.forEach((x, y) -> map.put(x, map.get(x) + y));
                if (sum > 0) {
                    String s = String.format("%.4f", (double) sum / (docs[i].length + docs[j].length - sum));
                    list.add(i + "," + j + ": " + s);
                }
            }
        }
        return list;
    }
}

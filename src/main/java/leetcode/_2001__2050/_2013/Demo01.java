package leetcode._2001__2050._2013;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));

        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }

    static class DetectSquares {

        private final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            map.computeIfAbsent(point[0], k -> new HashMap<>()).merge(point[1], 1, (x, y) -> x + 1);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1], count = 0;
            Map<Integer, Integer> empty = Collections.emptyMap();
            Map<Integer, Integer> sub = this.map.getOrDefault(x, empty);
            for (Map.Entry<Integer, Integer> entry : sub.entrySet()) {
                int y2 = entry.getKey(), v = entry.getValue();
                if (y2 == y) continue;
                int d = Math.abs(y - y2);
                int x3 = x - d, x4 = x - d, x5 = x + d, x6 = x + d;
                if (map.getOrDefault(x3, empty).containsKey(y) && map.getOrDefault(x4, empty).containsKey(y2)) {
                    count += v * map.get(x3).get(y) * map.get(x4).get(y2);
                }
                if (map.getOrDefault(x5, empty).containsKey(y) && map.getOrDefault(x6, empty).containsKey(y2)) {
                    count += v * map.get(x5).get(y) * map.get(x6).get(y2);
                }
            }
            return count;
        }
    }

}

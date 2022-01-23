package leetcode._2001__2050._2034;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {

    }

    @SuppressWarnings("unused")
    static class StockPrice {

        private int now;
        private final Map<Integer, Integer> map = new HashMap<>();
        private final TreeMap<Integer, Integer> tree = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            Integer ori = map.get(timestamp);
            if (ori != null) {
                Integer count = tree.get(ori);
                if (count == 1) tree.remove(ori);
                else tree.put(ori, count - 1);
            }
            tree.put(timestamp, tree.getOrDefault(timestamp, 0) + 1);
            map.put(timestamp, price);
            now = Math.max(now, timestamp);
        }

        public int current() {
            return map.get(now);
        }

        public int maximum() {
            return map.get(tree.lastKey());
        }

        public int minimum() {
            return map.get(tree.firstKey());
        }
    }

}

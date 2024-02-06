package leetcode._2501__2550._2502;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {

    }

    @SuppressWarnings("unused")
    static class Allocator {

        private TreeMap<Integer, Integer> map = new TreeMap<>();
        private Map<Integer, List<int[]>> cnt = new HashMap<>();

        public Allocator(int n) {
            map.put(0, n - 1);
        }

        public int allocate(int size, int mID) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey(), v = entry.getValue();
                if (v - k + 1 >= size) {
                    if (v - k + 1 > size) map.put(k + size, v);
                    map.remove(k);
                    cnt.computeIfAbsent(mID, x -> new ArrayList<>()).add(new int[]{k, size});
                    return k;
                }
            }
            return -1;
        }

        public int free(int mID) {
            List<int[]> list = cnt.getOrDefault(mID, Collections.emptyList());
            int ans = 0;
            for (int[] ints : list) {
                int from = ints[0], sum = ints[1], to = from + sum - 1;
                Map.Entry<Integer, Integer> lower = map.lowerEntry(from), higher = map.higherEntry(from);
                if (lower != null && lower.getValue() == from - 1) {
                    if (higher != null && higher.getKey() == to + 1) {
                        map.put(lower.getKey(), higher.getValue());
                        map.remove(higher.getKey());
                    } else map.put(lower.getKey(), to);
                } else if (higher != null && higher.getKey() == to + 1) {
                    map.remove(higher.getKey());
                    map.put(from, higher.getValue());
                } else map.put(from, to);
                ans += sum;
            }
            cnt.remove(mID);
            return ans;
        }
    }

}
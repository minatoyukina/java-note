package leetcode.race;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo5761 {

    @Test
    public void test() {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        findSumPairs.count(7);

    }

    @SuppressWarnings("all")
    class FindSumPairs {

        private Map<Integer, Integer> m1;
        private Map<Integer, Integer> m2;
        private int[] num2;


        public FindSumPairs(int[] nums1, int[] nums2) {
            m1 = new HashMap<>();
            m2 = new HashMap<>();
            this.num2 = nums2;
            for (int i : nums1) m1.put(i, m1.getOrDefault(i, 0) + 1);
            for (int i : nums2) m2.put(i, m2.getOrDefault(i, 0) + 1);
        }

        public void add(int index, int val) {
            int i = num2[index];
            m2.put(i, m2.get(i) - 1);
            m2.put(i + val, m2.getOrDefault(i + val, 0) + 1);
            num2[index] += val;
        }

        public int count(int tot) {
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                ans += m2.getOrDefault(tot - k, 0) * v;
            }
            return ans;
        }
    }
}

package leetcode._1801__1850._1818;

import org.junit.Test;

import java.util.TreeSet;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
    }

    private int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) set.add(i);
        int n = nums1.length, max = 0, mod = (int) 1e9 + 7;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum += abs;
            Integer x = nums2[i], y, z;
            if (set.contains(x)) max = Math.max(max, abs);
            if ((y = set.lower(x)) != null) max = Math.max(max, abs - Math.abs((nums2[i] - y)));
            if ((z = set.higher(x)) != null) max = Math.max(max, abs - Math.abs((nums2[i] - z)));
        }
        return (int) ((sum - max) % mod);
    }

}
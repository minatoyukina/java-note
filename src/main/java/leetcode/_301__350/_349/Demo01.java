package leetcode._301__350._349;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }


    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) for (int j : nums2) if (i == j) set.add(j);
        int[] ints = new int[set.size()];
        int count = 0;
        for (Integer integer : set) ints[count++] = integer;
        return ints;
    }

}

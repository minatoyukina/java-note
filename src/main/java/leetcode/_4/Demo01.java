package leetcode._4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> a = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> b = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list.addAll(a);
        list.addAll(b);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int size = collect.size();
        int middle = size / 2;
        if (size % 2 == 1) {
            return collect.get(middle);
        }
        return ((double) collect.get(middle - 1) + collect.get(middle)) / 2;
    }
}

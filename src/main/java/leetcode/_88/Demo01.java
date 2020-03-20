package leetcode._88;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, 3);
        merge(num1, 4, num2, 2);
        System.out.println(Arrays.toString(num1));
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList()).subList(0, m);
        List<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toList()).subList(0, n);
        l1.addAll(l2);
        List<Integer> collect = l1.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            nums1[i] = collect.get(i);
        }
    }
}

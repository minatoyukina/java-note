package leetcode._350;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }


    private int[] intersect(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length;
        if (a < b) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Map<Integer, Long> collect = Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = 0;
        int[] ans = new int[b];
        for (int i : nums2) {
            Long l = collect.get(i);
            if (l != null && l > 0) {
                ans[count++] = i;
                collect.put(i, l - 1);
            }
        }
        int[] copy = new int[count];
        System.arraycopy(ans, 0, copy, 0, count);
        return copy;
    }

}

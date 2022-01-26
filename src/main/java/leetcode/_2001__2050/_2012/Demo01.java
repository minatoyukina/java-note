package leetcode._2001__2050._2012;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(sumOfBeauties(new int[]{2, 4, 6, 4}));
        System.out.println(sumOfBeauties(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10}));
        System.out.println(sumOfBeauties(new int[]{3, 2, 1}));
    }

    public int sumOfBeauties(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 2; i < nums.length; i++) map.merge(nums[i], 1, (v1, v2) -> v1 + 1);
        int max = nums[0], sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int num = nums[i], next = nums[i + 1];
            Integer min = map.firstKey();
            if (min > num && num > max) sum += 2;
            else if (num > nums[i - 1] && num < nums[i + 1]) sum += 1;
            max = Math.max(max, num);
            Integer count = map.get(next);
            if (count != null) {
                if (count == 1) map.remove(next);
                else map.put(next, count - 1);
            }
        }
        return sum;
    }

}

package leetcode._2551__2600._2576;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxNumOfMarkedIndices(new int[]{57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92}));
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = (nums.length + 1) / 2; i < nums.length; i++) {
            int num = nums[i];
            tree.put(num, tree.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        for (int num : nums) {
            Integer k = tree.ceilingKey(num * 2);
            if (k != null) {
                if (tree.get(k) == 1) tree.remove(k);
                else tree.put(k, tree.get(k) - 1);
                cnt++;
            } else break;
        }
        return cnt * 2;
    }

}
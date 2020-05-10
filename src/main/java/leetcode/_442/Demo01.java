package leetcode._442;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{1}));
    }

    private List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            while (nums[i] != i + 1) {
                int j = nums[i] - 1;
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                if (nums[i] == nums[nums[i] - 1]) break;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) list.add(nums[i]);
        return list;
    }

}

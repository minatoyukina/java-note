package leetcode._201__250._228;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    private List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = i;
            while (x + 1 < nums.length && nums[x + 1] == nums[x] + 1) x++;
            if (i == x) list.add(String.valueOf(nums[i]));
            else list.add(nums[i] + "->" + nums[x]);
            i = x;
        }
        return list;
    }

}
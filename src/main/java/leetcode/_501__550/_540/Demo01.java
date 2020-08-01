package leetcode._501__550._540;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 4}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 4}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 4, 5, 5, 7, 7}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 4, 4, 5, 7, 7}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 6, 6, 7, 8, 8}));

    }

    private int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hi == nums.length - 1 && nums[hi] != nums[hi - 1]) return nums[hi];
            if (lo == 0 && nums[lo] != nums[lo + 1]) return nums[lo];
            if (nums[mid] == nums[mid + 1]) {
                if ((hi - lo) % 4 == 0) lo = mid;
                else hi = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if ((hi - lo) % 4 == 0) hi = mid;
                else lo = mid + 1;
            } else return nums[mid];
        }
        return nums[lo];
    }

}

package leetcode._201__250._220;

import org.junit.Test;

import java.util.TreeSet;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 1));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) return true;
            set.add((long) nums[i]);
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }

}

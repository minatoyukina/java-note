package leetcode._651__700._698;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(canPartitionKSubsets(new int[]{4}, 1));
    }

    private boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int len = sum / k;
        if (nums.length > 1) for (int i : nums) if (i > len || (i < len && i + nums[0] > len)) return false;
        return dfs(nums, new HashSet<>(), k, 0, 0, len);
    }

    private boolean dfs(int[] nums, Set<Integer> set, int k, int count, int sum, int len) {
        if (sum == len) {
            count++;
            sum = 0;
        }
        if (count > k || sum > len) return false;
        if (set.size() == nums.length && count == k) return true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.contains(i)) {
                set.add(i);
                if (dfs(nums, set, k, count, sum + nums[i], len)) return true;
                set.remove(i);
            }
        }
        return false;
    }
}
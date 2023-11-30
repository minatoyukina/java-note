package leetcode._2351__2400._2389;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) ans[i] = search(nums, queries[i]) + 1;
        return ans;
    }

    int search(int[] nums, int target) {
        if (nums[0]>target) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (left == right - 1) return nums[right] <= target ? right : left;
            if (nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return left;
    }

}
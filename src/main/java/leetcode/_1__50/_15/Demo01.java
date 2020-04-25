package leetcode._1__50._15;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, 0, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    int x = nums[i], y = nums[j], z = nums[map.get(nums[j])];
                    int max = Math.max(x, Math.max(y, z));
                    int min = Math.min(x, Math.min(y, z));
                    ans.add(Arrays.asList(min, 0 - max - min, max));
                }
                map.put(0 - nums[i] - nums[j], j);
                if (i >= 1) if (nums[i - 1] + nums[i] + nums[j] >= 0) break;
            }
        }
        return new ArrayList<>(ans);
    }
}

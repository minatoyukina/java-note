package leetcode._1__50._18;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 1));
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] dp = new int[nums.length][nums.length];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = nums[i] + nums[j];
                List<int[]> tmp = map.getOrDefault(dp[i][j], new ArrayList<>());
                tmp.add(new int[]{i, j});
                map.put(dp[i][j], tmp);
                List<int[]> ints = map.get(target - dp[i][j]);
                if (ints != null) {
                    for (int[] arr : ints) {
                        if (arr[0] != i && arr[0] != j && arr[1] != i && arr[1] != j) {
                            list.add(new ArrayList<>(Arrays.asList(nums[arr[0]], nums[arr[1]], nums[i], nums[j])));
                        }
                    }
                }
            }
        }
        return list.stream().peek(s -> s.sort(Integer::compareTo)).distinct().collect(Collectors.toList());
    }

}
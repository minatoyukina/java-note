package leetcode._39;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(combinationSum(new int[]{1, 2, 3}, 3));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7, 4}, 7));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<List<Integer>> list = new HashSet<>();
        combine(Arrays.stream(candidates).boxed().collect(Collectors.toList()), new ArrayList<>(), target, list);
        return new ArrayList<>(list);
    }

    private void combine(List<Integer> nums, List<List<Integer>> list, int target, Set<List<Integer>> answer) {
        if (list.isEmpty()) {
            for (Integer num : nums) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(num);
                if (num == target) {
                    answer.add(tmp);
                }
                if (num < target) {
                    list.add(tmp);
                }
            }
        }
        List<List<Integer>> copy = new ArrayList<>();
        for (Integer num : nums) {
            for (List<Integer> aList : list) {
                List<Integer> integerList = new ArrayList<>(aList);
                integerList.add(num);
                Integer sum = integerList.stream().reduce(Integer::sum).orElse(target);
                if (sum == target) {
                    answer.add(integerList.stream().sorted().collect(Collectors.toList()));
                }
                if (sum < target) {
                    copy.add(integerList);
                }
            }
        }
        if (copy.isEmpty()) {
            return;
        }
        combine(nums, copy, target, answer);
    }
}

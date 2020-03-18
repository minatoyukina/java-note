package leetcode._40_;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(combinationSum2(new int[]{1, 2, 3, 1}, 3));
        System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> list = new HashSet<>();
        combine(Arrays.stream(candidates).boxed().collect(Collectors.toList()), new ArrayList<>(), target, list);
        return new ArrayList<>(list);
    }

    private void combine(List<Integer> nums, List<List<Integer>> list, int target, Set<List<Integer>> answer) {
        if (nums.size() == 0) {
            return;
        }
        Integer first = nums.get(0);
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> aList : list) {
            List<Integer> integerList = new ArrayList<>(aList);
            integerList.add(first);
            Integer sum = integerList.stream().reduce(Integer::sum).orElse(target - 1);
            if (sum == target) {
                answer.add(integerList.stream().sorted().collect(Collectors.toList()));
            }
            if (sum < target) {
                copy.add(integerList);
            }
        }
        list.addAll(copy);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(first);
        if (first == target) {
            answer.add(tmp);
        }
        if (first < target) {
            list.add(tmp);
        }
        nums.remove(0);
        combine(nums, list, target, answer);
    }
}

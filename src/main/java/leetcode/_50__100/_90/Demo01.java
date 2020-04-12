package leetcode._50__100._90;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 2}));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new CopyOnWriteArrayList<>();
        re(Arrays.stream(nums).boxed().collect(Collectors.toList()), list);
        list.add(new ArrayList<>());
        return list.stream().peek(s -> s.sort(Integer::compareTo)).distinct().collect(Collectors.toList());
    }

    private void re(List<Integer> list, List<List<Integer>> answer) {
        if (list.size() == 0) {
            return;
        }
        Integer integer = list.get(0);
        for (List<Integer> integers : answer) {
            List<Integer> copy = new ArrayList<>(integers);
            copy.add(integer);
            answer.add(copy);
        }
        answer.add(Collections.singletonList(integer));
        list.remove(0);
        re(list, answer);
    }
}

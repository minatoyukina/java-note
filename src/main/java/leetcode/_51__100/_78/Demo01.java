package leetcode._51__100._78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(Collections.singletonList(nums[i]));
            for (int j = i + 1; j < nums.length; j++) {
                for (List<Integer> integers : list) {
                    if (integers.get(0) == nums[i]) {
                        List<Integer> copy = new ArrayList<>(integers);
                        copy.add(nums[j]);
                        list.add(copy);
                    }
                }
            }
        }
        list.add(new ArrayList<>());
        return list;
    }
}

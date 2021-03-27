package leetcode._451__500._456;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
    }

    private boolean find132pattern(int[] nums) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    list.add(new Pair<>(i, j));
                }
            }
        }
        for (Pair<Integer, Integer> pair : list) {
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            for (int i = value + 1; i < nums.length; i++) {
                if (nums[i] > nums[key] && nums[i] < nums[value]) return true;
            }
        }
        return false;
    }

}
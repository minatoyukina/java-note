package leetcode._15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, 0, 1}));
        System.out.println(threeSum(new int[]{1, 2, -2, -1}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (length < 3) {
            return list;
        }
        for (int i = 0; i < length; i++) {
            collect.remove(0);
            for (int j = i + 1; j < length; j++) {
//                int x = nums[i], y = nums[j], z = 0 - x - y;
//                if (collect.contains(z)) {
//                    List<Integer> integerList = new ArrayList<>();
//                    int min = Math.min(Math.min(x, y), z);
//                    int max = Math.max(Math.max(x, y), z);
//                    integerList.add(min);
//                    integerList.add(0 - min - max);
//                    integerList.add(max);
//                    if (!list.contains(integerList)) {
//                        list.add(integerList);
//                    }
//                }
                for (int k = j + 1; k < length; k++) {
                    int x = nums[i], y = nums[j], z = nums[k];
                    if (x + y + z == 0) {
                        List<Integer> integerList = new ArrayList<>();
                        int min = Math.min(Math.min(x, y), z);
                        int max = Math.max(Math.max(x, y), z);
                        integerList.add(min);
                        integerList.add(0 - min - max);
                        integerList.add(max);
//                        if (!list.contains(integerList))
                        list.add(integerList);

                    }
                }
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}

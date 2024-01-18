package leetcode._2151__2200._2170;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(minimumOperations(new int[]{69, 45, 24, 74, 63, 43, 15, 91, 40, 15, 74, 37, 51, 5, 59, 36, 62, 54, 41, 39, 87, 29, 96, 17, 61, 39, 80, 55, 67, 3, 58, 44, 53, 92, 94, 49, 45, 61, 82, 9, 64, 93, 34, 13, 61, 44, 66, 45, 7, 29, 58, 54, 14, 68, 84, 13, 11, 16, 80, 28, 61, 99, 51, 100, 89, 58, 42, 32, 42, 37, 71, 12, 41, 62, 29, 78, 4, 1, 17, 13, 46, 26, 75}));
    }

    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> odd = new HashMap<>(), even = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            else odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }
        int ko = odd.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(0);
        int ke = even.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(0);
        int o1 = odd.values().stream().max(Integer::compareTo).orElse(0);
        int e1 = even.values().stream().max(Integer::compareTo).orElse(0);
        int o2 = odd.values().stream().sorted((x, y) -> y - x).skip(1).findFirst().orElse(0);
        int e2 = even.values().stream().sorted((x, y) -> y - x).skip(1).findFirst().orElse(0);
        return nums.length - (ko == ke && o1 > o2 && e1 > e2 ? Math.max(o1 + e2, o2 + e1) : o1 + e1);
    }
}

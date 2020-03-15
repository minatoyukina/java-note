package leetcode._46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> permute(int[] nums) {
        Map<List<Integer>, List<Integer>> map = new ConcurrentHashMap<>();
        permute(map, Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

    }

    private void permute(Map<List<Integer>, List<Integer>> map, List<Integer> nums) {
        if (map.size() == 0) {
            for (Integer word : nums) {
                List<Integer> values = new ArrayList<>(nums);
                List<Integer> keys = new ArrayList<>();
                keys.add(word);
                values.remove(word);
                map.put(keys, values);
            }
        }
        map.forEach((x, y) -> {
            if (y.size() > 0) {
                map.remove(x);
                for (Integer s : y) {
                    List<Integer> keys = new ArrayList<>(x);
                    keys.add(s);
                    List<Integer> values = new ArrayList<>(y);
                    values.remove(s);
                    map.put(keys, values);
                    permute(map, values);
                }
            }
        });
    }
}

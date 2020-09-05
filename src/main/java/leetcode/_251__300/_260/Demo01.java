package leetcode._251__300._260;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    private int[] singleNumber(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> list = map.entrySet().stream()
                .filter(s -> s.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

}

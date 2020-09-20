package leetcode._551__600._554;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(leastBricks(new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 2, 2, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 1, 1)
                )
        )));
    }

    private int leastBricks(List<List<Integer>> wall) {
        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                res.add(sum);
            }
        }
        System.out.println(res);
        Long max = res.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().max(Long::compareTo).orElse(0L);
        return (int) (wall.size() - max);
    }

}

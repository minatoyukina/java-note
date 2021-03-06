package leetcode._451__500._491;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findSubsequences(new int[]{4, 3, 7, 7, 5}));
        System.out.println(findSubsequences(new int[]{4, 3, 2, 1}));
    }

    private List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new CopyOnWriteArrayList<>();
        for (int num : nums) {
            List<Integer> sub = new ArrayList<>();
            sub.add(num);
            list.add(sub);
            for (int i = list.size() - 2; i >= 0; i--) {
                List<Integer> tmp = list.get(i);
                if (num >= tmp.get(tmp.size() - 1)) {
                    List<Integer> copy = new ArrayList<>(tmp);
                    copy.add(num);
                    list.add(copy);
                }
            }
        }
        return list.stream().filter(s -> s.size() > 1).distinct().collect(Collectors.toList());
    }

}

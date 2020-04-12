package leetcode._50__100._77;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class Demo01 {

    @Test
    public void test() {
        combine(20, 19).forEach(System.out::println);
        combine(7, 2).forEach(System.out::println);
    }

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new CopyOnWriteArrayList<>();
        int min = Math.min(n, k);
        IntStream.rangeClosed(1, n).forEach(s -> {
            List<Integer> list = new ArrayList<>();
            lists.forEach(x -> {
                if (x.size() + (n - s) < min) lists.remove(x);
                List<Integer> copy = new ArrayList<>(x);
                copy.add(s);
                if (copy.size() <= min) lists.add(copy);
            });
            if (s <= n - min + 1) {
                list.add(s);
                lists.add(list);
            }
        });
        return lists;
    }
}

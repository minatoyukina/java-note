package leetcode.lcof;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo62 {

    @Test
    public void test() {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
    }

    private int lastRemaining(int n, int m) {
        List<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toList());
        int offset = 0;
        while (list.size() > 1) {
            offset = Math.floorMod(offset + m - 1, list.size());
            list.remove(offset);
        }
        return list.get(0);
    }


}

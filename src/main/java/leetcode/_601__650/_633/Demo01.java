package leetcode._601__650._633;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(12));
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
    }

    private boolean judgeSquareSum(int c) {
        int x = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= x; i++) set.add(i * i);
        for (int i = 0; i <= x; i++) if (set.contains(i * i) && set.contains((c - i * i))) return true;
        return false;
    }

}

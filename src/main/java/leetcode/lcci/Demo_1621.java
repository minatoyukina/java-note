package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1621 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3})));
    }

    private int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array1) {
            set.add(i);
            sum1 += i;
        }
        for (int i : array2) sum2 += i;
        if ((sum1 - sum2) % 2 != 0) return new int[0];
        int x = (sum1 - sum2) / 2;
        for (int i : array2) if (set.contains(x + i)) return new int[]{x + i, i};
        return new int[0];
    }


}

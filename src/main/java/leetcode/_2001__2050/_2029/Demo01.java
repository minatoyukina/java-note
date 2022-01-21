package leetcode._2001__2050._2029;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(stoneGameIX(new int[]{2, 1}));
        System.out.println(stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }

    public boolean stoneGameIX(int[] stones) {
        int d0 = 0, d1 = 0, d2 = 0;
        for (int stone : stones) {
            if (stone % 3 == 0) d0++;
            if (stone % 3 == 1) d1++;
            if (stone % 3 == 2) d2++;
        }
        return d0 % 2 == 0 ? d1 > 0 && d2 > 0 : d2 > d1 + 2 || d1 > d2 + 2;
    }

}

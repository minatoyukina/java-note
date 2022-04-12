package leetcode._2051__2100._2087;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(minCost(new int[]{5, 5}, new int[]{5, 2}, new int[]{7, 1, 3, 3, 5, 3, 22, 10, 23}, new int[]{5, 5, 6, 2, 0, 16}));
        System.out.println(minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ax = startPos[0], ay = startPos[1], bx = homePos[0], by = homePos[1];
        int x1 = Math.min(ax, bx), x2 = Math.max(ax, bx), y1 = Math.min(ay, by), y2 = Math.max(ay, by);
        int cost = 0;
        for (int i = x1; i <= x2; i++) cost += rowCosts[i];
        for (int i = y1; i <= y2; i++) cost += colCosts[i];
        return cost - rowCosts[ax] - colCosts[ay];
    }


}

package leetcode._1401;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(checkOverlap(2, 1, 2, 2, -3, 1, 2));
        System.out.println(checkOverlap(1206, -5597, -276, -5203, -1795, -4648, 1721));
    }

    private boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if (x1 > x_center + radius || x2 < x_center - radius || y1 > y_center + radius || y2 < y_center - radius)
            return false;
        if (x1 > x_center && y1 > y_center && Math.pow(x1 - x_center, 2) + Math.pow(y1 - y_center, 2) > radius * radius)
            return false;
        if (x1 > x_center && y2 < y_center && Math.pow(x1 - x_center, 2) + Math.pow(y2 - y_center, 2) > radius * radius)
            return false;
        if (x2 < x_center && y1 > y_center && Math.pow(x2 - x_center, 2) + Math.pow(y1 - y_center, 2) > radius * radius)
            return false;
        if (x2 < x_center && y2 < y_center && Math.pow(x2 - x_center, 2) + Math.pow(y2 - y_center, 2) > radius * radius)
            return false;
        return true;
    }
}

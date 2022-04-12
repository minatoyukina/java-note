package leetcode._1301__1350._1344;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(angleClock(12, 30));
    }

    public double angleClock(int hour, int minutes) {
        double h = hour / 12.0 * 360 + minutes / 2.0, m = minutes / 60.0 * 360;
        double abs = Math.abs(h - m);
        return abs >= 180 ? 360 - abs : abs;
    }

}
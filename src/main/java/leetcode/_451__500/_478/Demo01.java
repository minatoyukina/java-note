package leetcode._451__500._478;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(new Solution(1, 0, 0).randPoint()));
    }

    @SuppressWarnings("all")
    class Solution {

        double x, y, r;

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            double max = r * 1.000001;
            double a = Math.random() * max;
            double b = Math.random() * max;
            if (a * a + b * b < r * r) {
                return new double[]{x + a * (new Random().nextInt(2) == 0 ? 1 : -1),
                        y + b * (new Random().nextInt(2) == 0 ? 1 : -1)};
            }
            return randPoint();
        }
    }

}
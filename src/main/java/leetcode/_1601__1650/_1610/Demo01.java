package leetcode._1601__1650._1610;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(visiblePoints(
                Lists.newArrayList(
                        Lists.newArrayList(1, 1),
                        Lists.newArrayList(2, 1),
                        Lists.newArrayList(2, 2),
                        Lists.newArrayList(3, 4)
                ),
                90,
                Lists.newArrayList(1, 1)));
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double agl = angle / 360.0 * Math.PI;
        int ox = location.get(0), oy = location.get(1);
        int count = 0;
        for (List<Integer> point : points) {
            int x = point.get(0), y = point.get(1);
            if ((ox == x && oy == y) || (ox == x && angle >= 180)) {
                count++;
                continue;
            }
            double atan = Math.atan(Math.abs((double) (y - oy) / (x - ox)));
            if (x > ox) {
                if (angle >= 180 || atan <= agl) {
                    count++;
                }
            }
            if (x < ox) {
                if (angle >= 180 && atan >= agl) {
                    count++;
                }
            }
        }
        return count;
    }

}
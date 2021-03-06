package leetcode._951__1000._973;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2},
        }, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4},
        }, 2)));
    }


    private int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];
        List<int[]> list = Arrays.stream(points)
                .sorted((y, x) -> y[1] * y[1] + y[0] * y[0] - x[1] * x[1] - x[0] * x[0])
                .limit(k).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i)[0];
            arr[i][1] = list.get(i)[1];
        }
        return arr;
    }

}

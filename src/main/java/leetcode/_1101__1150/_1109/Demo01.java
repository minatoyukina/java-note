package leetcode._1101__1150._1109;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            diff[booking[0]-1] += booking[2];
            diff[booking[1]] -= booking[2];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] += (i == 0 ? 0 : ans[i - 1]) + diff[i];
        }
        return ans;
    }

}
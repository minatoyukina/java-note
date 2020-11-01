package leetcode._801__850._849;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    private int maxDistToClosest(int[] seats) {
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int l = i, r = i, dl = 0, dr = 0;
                while (l >= 0 && seats[l] == 0) {
                    l--;
                    dl++;
                    if (l == -1) dl = Integer.MAX_VALUE;
                }
                while (r < seats.length && seats[r] == 0) {
                    r++;
                    dr++;
                    if (r == seats.length) dr = Integer.MAX_VALUE;
                }
                ans = Math.max(ans, Math.min(dl, dr));
            }
        }
        return ans;
    }

}

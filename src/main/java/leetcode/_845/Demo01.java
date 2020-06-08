package leetcode._845;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(longestMountain(new int[]{2, 2, 2}));
        System.out.println(longestMountain(new int[]{40, 51, 29, 19, 50, 25}));
    }

    private int longestMountain(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int x = i, y = i, tmp = 1;
                while (x > 0 && A[x - 1] < A[x]) {
                    x--;
                    tmp++;
                }
                while (y < A.length - 1 && A[y + 1] < A[y]) {
                    y++;
                    tmp++;
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }

}

package leetcode._1395;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(numTeams(new int[]{1, 2, 3, 4}));
    }


    private int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 0; i < rating.length; i++) {
            int left = 0, right = 0;
            for (int x = 0; x < i; x++) {
                if (rating[x] < rating[i]) left++;
            }
            for (int x = i + 1; x < rating.length; x++) {
                if (rating[x] > rating[i]) right++;
            }
            ans += left * right;
            left = 0;
            right = 0;
            for (int x = 0; x < i; x++) {
                if (rating[x] > rating[i]) left++;
            }
            for (int x = i + 1; x < rating.length; x++) {
                if (rating[x] < rating[i]) right++;
            }
            ans += left * right;
        }
        return ans;
    }
}

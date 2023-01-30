package leetcode._1951__2000._1963;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }

    private int minSwaps(String s) {
        int cnt = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') cnt++;
            else if (cnt > 0) cnt--;
            else {
                cnt++;
                ans++;
            }
        }
        return ans;
    }

}
package leetcode._951__1000._974;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }


    private int subarraysDivByK(int[] A, int K) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : A) {
            sum += i;
            //求Mod 不能用sum%K
            int mod = (sum % K + K) % K;
            if (map.containsKey(mod)) ans += map.get(mod);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }

}

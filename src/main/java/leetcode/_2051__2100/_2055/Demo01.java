package leetcode._2051__2100._2055;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(platesBetweenCandles("*|*||||**|||||||*||*||*||**|*|*||*", new int[][]{{2, 33}, {2, 32}})));
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0, pre = s.indexOf('|') + 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                sum += i - pre - 1;
                map.put(i, sum);
                pre = i;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Integer left = map.ceilingKey(query[0]), right = map.floorKey(query[1]);
            if (left != null && right != null && right > left) ans[i] = map.get(right) - map.get(left);
        }
        return ans;
    }


}

package leetcode._1251__1300._1262;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxSumDivThree(new int[]{2, 6, 2, 2, 7}));
        System.out.println(maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
    }

    private int maxSumDivThree(int[] nums) {
        int sum = 0;
        // 余数为1
        List<Integer> d1 = new ArrayList<>();
        // 余数为2
        List<Integer> d2 = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) d1.add(num);
            if (num % 3 == 2) d2.add(num);
        }
        d1.sort(Integer::compareTo);
        d2.sort(Integer::compareTo);
        int a = d1.size();
        int b = d2.size();
        int max = 0;
        /*
          两种配对模式，取3n个d1/d2，或者相同数目的d1和d2。
          最后剩下的只可能是1个d1,2个d1,1个d2,2个d2或者全部匹配5种情况。
         */
        if (a % 3 == b % 3) return Math.max(max, sum);
        if (d1.size() >= 1 && (a - 1) % 3 == b % 3) max = Math.max(max, sum - d1.get(0));
        if (d1.size() >= 2 && (a - 2) % 3 == b % 3) max = Math.max(max, sum - d1.get(0) - d1.get(1));
        if (d2.size() >= 1 && (b - 1) % 3 == a % 3) max = Math.max(max, sum - d2.get(0));
        if (d2.size() >= 2 && (b - 2) % 3 == a % 3) max = Math.max(max, sum - d2.get(0) - d2.get(1));
        return max;
    }

}
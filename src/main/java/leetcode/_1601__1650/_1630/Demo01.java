package leetcode._1601__1650._1630;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], arr, 0, arr.length);
            Arrays.sort(arr);
            int sub = arr[1] - arr[0];
            boolean b = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != sub) {
                    b = false;
                    break;
                }
            }
            list.add(b);
        }
        return list;
    }

}
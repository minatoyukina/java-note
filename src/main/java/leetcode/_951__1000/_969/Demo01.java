package leetcode._951__1000._969;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = arr[i];
            if (x != i + 1) {
                int pos = -1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] == i + 1) {
                        pos = j;
                        break;
                    }
                }
                reverse(arr, pos);
                reverse(arr, i);
                list.add(pos + 1);
                list.add(i + 1);
            }
        }
        return list;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0; i <= end / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[end - i];
            arr[end - i] = tmp;
        }
    }

}
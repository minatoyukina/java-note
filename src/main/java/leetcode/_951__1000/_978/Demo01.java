package leetcode._951__1000._978;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxTurbulenceSize(new int[]{100}));
        System.out.println(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

    private int maxTurbulenceSize(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) return 1;
        int max = 1, count = 2;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 1] >= arr[i] && arr[i + 2] >= arr[i + 1]) {
                max = Math.max(max, count);
                count = 2;
                continue;
            }
            if (arr[i + 1] <= arr[i] && arr[i + 2] <= arr[i + 1]) {
                max = Math.max(max, count);
                count = 2;
                continue;
            }
            count++;
        }
        return Math.max(max, count);
    }

}
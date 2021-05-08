package leetcode._1701__1750._1723;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumTimeRequired(new int[]{6518448, 8819833, 7991995, 7454298, 2087579, 380625, 4031400, 2905811, 4901241, 8480231, 7750692, 3544254}, 4));
        System.out.println(minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    private int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        for (int i = 0; i < jobs.length / 2; i++) {
            int tmp = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = tmp;
        }
        int left = jobs[0], right = IntStream.of(jobs).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(jobs, k, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] jobs, int k, int max) {
        return dfs(new int[k], jobs, max, 0);
    }

    private boolean dfs(int[] arr, int[] jobs, int max, int index) {
        if (index >= jobs.length) return true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + jobs[index] <= max) {
                arr[i] += jobs[index];
                if (dfs(arr, jobs, max, index + 1)) return true;
                arr[i] -= jobs[index];
            }
            if (arr[i] == 0 || arr[i] + jobs[index] == max) break;
        }
        return false;
    }

}
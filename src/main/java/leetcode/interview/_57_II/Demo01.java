package leetcode.interview._57_II;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(intToRoman(9)));
        System.out.println(Arrays.deepToString(intToRoman(10)));
    }

    private int[][] intToRoman(int target) {
        int count = 0;
        int q = 0;
        for (int i = target / 2; i >= 2; i--) {
            if ((target % i == 0 && i % 2 == 1) || ((double) target / i + "").endsWith(".5")) {
                for (int j = 0; j < i; j++) {
                    int tmp = (int) Math.ceil((double) target / i - i / 2.0 + j);
                    if (tmp < 1) {
                        q--;
                        break;
                    }
                }
                q++;
            }
        }

        int[][] ints = new int[q][target / 2];
        for (int i = target / 2; i >= 2; i--) {
            if ((target % i == 0 && i % 2 == 1) || ((double) target / i + "").endsWith(".5")) {
                for (int j = 0; j < i; j++) {
                    int tmp = (int) Math.ceil((double) target / i - i / 2.0 + j);
                    if (tmp < 1) {
                        count--;
                        break;
                    }
                    ints[count][j] = tmp;
                }
                count++;
            }
        }
        int[][] answer = new int[count][];
        for (int i = 0; i < count; i++) {
            if (ints[i][0] == 0) {
                break;
            }
            int s = 0;
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] != 0) {
                    s++;
                }
            }
            answer[i] = new int[s];
            System.arraycopy(ints[i], 0, answer[i], 0, answer[i].length);
        }
        return answer;
    }
}

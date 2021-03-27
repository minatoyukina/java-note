package leetcode._751__800._765;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSwapsCouples(new int[]{1, 4, 0, 5, 8, 7, 6, 3, 2, 9}));
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}));
    }

    private int minSwapsCouples(int[] row) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            int[] copy = Arrays.copyOf(row, row.length);
            min = Math.min(min, dfs(i, 0, copy));
        }
        return min;
    }

    private int dfs(int index, int count, int[] row) {
        if (index >= row.length) return dfs(0, count, row);
        boolean flag = true;
        for (int i = 0; i < row.length - 1; i = i + 2) {
            if (row[i] / 2 != row[i + 1] / 2) {
                flag = false;
                break;
            }
        }
        if (flag) return count;
        if (index % 2 == 0 && index < row.length - 1) {
            if (row[index] / 2 != row[index + 1] / 2) {
                for (int i = 0; i < row.length; i++) {
                    if (row[i] / 2 == row[index] / 2 && index != i) {
                        int tmp = row[index + 1];
                        row[index + 1] = row[i];
                        row[i] = tmp;
                        count++;
                        return dfs(i, count, row);
                    }
                }
            }
        }
        if (index % 2 == 1 && index > 0) {
            if (row[index] / 2 != row[index - 1] / 2) {
                for (int i = 0; i < row.length; i++) {
                    if (row[i] / 2 == row[index] / 2 && index != i) {
                        int tmp = row[index - 1];
                        row[index - 1] = row[i];
                        row[i] = tmp;
                        count++;
                        return dfs(i, count, row);
                    }
                }
            }
        }
        return dfs(index + (index % 2 == 0 ? 2 : 1), count, row);
    }
}

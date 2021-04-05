package leetcode._201__250._240;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{
                {-1},
                {-1},
        }, -1));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 4));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

        }, 5));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        return dfs(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean dfs(int[][] matrix, int target, int lm, int ln, int rm, int rn) {
        if (outOfRange(matrix, lm, ln) || outOfRange(matrix, rm, rn) || rm < lm || rn < ln) return false;
        if (target < matrix[lm][ln] || target > matrix[rm][rn]) return false;
        int mm = (lm + rm) / 2;
        int mn = (ln + rn) / 2;
        if (matrix[mm][mn] > target)
            return dfs(matrix, target, lm, ln, mm - 1, rn) || dfs(matrix, target, mm, ln, rm, mn);
        else if (matrix[mm][mn] < target)
            return dfs(matrix, target, lm, mn + 1, mm, rn) || dfs(matrix, target, mm + 1, ln, rm, rn);
        else return true;
    }

    private boolean outOfRange(int[][] board, int x, int y) {
        return x < 0 || y < 0 || x >= board.length || y >= board[0].length;
    }

}
package leetcode._1451__1500._1476;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {

    }

    @SuppressWarnings("all")
    static class SubrectangleQueries {

        private final int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }

}
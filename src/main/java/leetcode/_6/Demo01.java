package leetcode._6;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(convert("ABC", 2));
        System.out.println(convert("LEETCODEISHIRINGS", 3));
    }

    private String convert(String s, int numRows) {
        int peer = (numRows * 2 - 2);
        if (peer <= 0) {
            return s;
        }
        int round = s.length() / peer + 1;
        int numCols = (numRows - 1) * round;
        StringBuilder answer = new StringBuilder();
        char[][] chars = new char[numRows][numCols];
        for (int i = 0; i < s.length(); i++) {
            int x = i / peer;
            int y = i % peer;
            if (y < numRows) {
                chars[y][x * (numRows - 1)] = s.charAt(i);
            } else {
                chars[numRows - y % numRows - 2][x * (numRows - 1) + y % numRows + 1] = s.charAt(i);
            }
            System.out.println(Arrays.deepToString(chars).replaceAll("\\u0000", " "));
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                char s1 = chars[i][j];
                if (s1 != '\u0000') {
                    answer.append(s1);
                }
            }
        }
        return answer.toString();
    }
}

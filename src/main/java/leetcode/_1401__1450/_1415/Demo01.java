package leetcode._1401__1450._1415;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {

        System.out.println(getHappyString(10, 100));
    }

    public String getHappyString(int n, int k) {
        count = k;
        return dfs(n, new StringBuilder());
    }

    private int count;

    private String dfs(int n, StringBuilder sb) {
        int pos = sb.length();
        if (pos >= n) {
            count--;
            return count <= 0 ? sb.toString() : "";
        }
        if (pos == 0) {
            for (int j = 0; j < 3; j++) {
                String dfs = dfs(n, new StringBuilder(sb).append((char) ('a' + j)));
                if (!dfs.isEmpty()) {
                    return dfs;
                }
            }
        } else {
            for (int j = 0; j < 2; j++) {
                String dfs = dfs(n, new StringBuilder(sb).append(next(sb.toString().charAt(pos - 1), j)));
                if (!dfs.isEmpty()) {
                    return dfs;
                }
            }
        }
        return "";
    }

    private char next(char a, int i) {
        if (a == 'a') return i == 0 ? 'b' : 'c';
        else if (a == 'b') return i == 0 ? 'a' : 'c';
        else return i == 0 ? 'a' : 'b';
    }

}
package leetcode._201__250._212;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findWords(
                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}));

    }

    private List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        label:
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0, new boolean[board.length][board[0].length])) {
                        list.add(word);
                        continue label;
                    }
                }
            }
        }
        return list;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        if (index >= word.length()) return true;
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && word.charAt(index) == board[x][y]) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i * j != 0 || (i == 0 && j == 0)) continue;
                    visited[x][y] = true;
                    if (dfs(board, word, x + i, y + j, index + 1, visited)) return true;
                    visited[x][y] = false;
                }
            }
        }
        return false;
    }

}
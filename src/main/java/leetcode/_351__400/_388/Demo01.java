package leetcode._351__400._388;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(lengthLongestPath("dir\n        file.txt"));
        System.out.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
        System.out.println(lengthLongestPath("a"));
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }


    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] split = input.split("\n");
        int count = 0, max = 0, level = 0;
        for (String s : split) {
            int n = tCount(s);
            if (n != level) {
                int x = level - n;
                while (x-- > 0) {
                    level--;
                    count -= stack.pop();
                }
            }
            if (s.contains(".")) {
                max = Math.max(max, count + s.length());
                continue;
            }
            count += s.length() - n;
            stack.add(s.length() - n);
            level++;
        }
        return max;
    }

    private int tCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\t') count++;
            else break;
        }
        return count;
    }


}
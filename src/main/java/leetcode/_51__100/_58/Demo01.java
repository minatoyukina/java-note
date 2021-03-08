package leetcode._51__100._58;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord(" "));
    }

    private int lengthOfLastWord(String s) {
        String[] split = s.split("\\s+");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }
}

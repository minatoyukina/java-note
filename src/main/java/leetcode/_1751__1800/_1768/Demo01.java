package leetcode._1751__1800._1768;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    private String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) sb.append(word1.substring(min));
        else sb.append(word2.substring(min));
        return sb.toString();
    }

}
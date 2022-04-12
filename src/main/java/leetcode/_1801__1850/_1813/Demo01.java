package leetcode._1801__1850._1813;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(areSentencesSimilar("abc", "abc"));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return check(sentence1, sentence2) || check(sentence2, sentence1);
    }

    private boolean check(String s1, String s2) {
        if (s1.equals(s2) || s2.startsWith(s1 + " ") || s2.endsWith(" " + s1)) return true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                if (s2.startsWith(s1.substring(0, i + 1)) && s2.endsWith(s1.substring(i)) && s2.length() >= s1.length())
                    return true;
            }
        }
        return false;
    }

}
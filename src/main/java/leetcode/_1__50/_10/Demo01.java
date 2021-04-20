package leetcode._1__50._10;

import org.junit.Test;

import java.util.regex.Pattern;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aa", "a"));
    }

    private boolean isMatch(String s, String p) {
        return Pattern.compile(p).matcher(s).matches();
    }

}
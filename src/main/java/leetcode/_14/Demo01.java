package leetcode._14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    private String longestCommonPrefix(String[] strs) {
        String s = "";
        if (strs.length == 0) {
            return s;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (!str.startsWith(strs[0].substring(0, i + 1))) {
                    return s;
                }
            }
            s = strs[0].substring(0, i + 1);
        }
        return s;
    }
}

package leetcode._751__800._784;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
    }

    private List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        Set<String> set = new ConcurrentSkipListSet<>();
        set.add(S);
        LinkedHashMap<Integer, Character> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                map.put(i, chars[i]);
            }
        }
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            Integer i = entry.getKey();
            for (String s : set) {
                char[] clone = s.toCharArray().clone();
                set.add(new String(clone));
                if (clone[i] >= 'a' && clone[i] <= 'z') {
                    clone[i] = (char) (chars[i] - 32);
                    set.add(new String(clone));
                } else {
                    clone[i] = (char) (chars[i] + 32);
                    set.add(new String(clone));
                }
            }
        }
        return new ArrayList<>(set);
    }

}

package leetcode._820;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"me", "time"}));
        System.out.println(minimumLengthEncoding(new String[]{"t"}));
    }

    private int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (x, y) -> y.length() - x.length());
        Set<String> set = new HashSet<>();
        for (String s : words) {
            if (set.stream().noneMatch(t -> t.contains(s) && !t.startsWith(s))) {
                set.add(s);
            }
        }
        int ans = 0;
        for (String s : set) ans += s.length() + 1;
        return ans;
    }

}

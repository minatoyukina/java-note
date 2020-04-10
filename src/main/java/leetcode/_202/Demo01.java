package leetcode._202;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
    }

    private boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, Set<Integer> set) {
        int s = 0;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            int parseInt = Integer.parseInt(str.charAt(i) + "");
            s += parseInt * parseInt;
        }
        if (set.contains(s)) return false;
        else set.add(s);
        if (s == 1) return true;
        return isHappy(s, set);
    }
}

package leetcode._801__850._838;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pushDominoes("L.LL......"));
        System.out.println(pushDominoes("RR.L"));
    }

    public String pushDominoes(String dominoes) {
        int pos = 0;
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'L' || i == chars.length - 1) {
                while (i + 1 < dominoes.length() && dominoes.charAt(i + 1) != 'R') i++;
                int left = pos, right = i;
                String ss = dominoes.substring(left, right + 1);
                int l = left + ss.lastIndexOf("R"), r = left + ss.indexOf("L");
                if (l >= left) for (int x = left + 1; x < l; x++) if (chars[x - 1] == 'R') chars[x] = 'R';
                if (r >= left) for (int x = right - 1; x > r; x--) if (chars[x + 1] == 'L') chars[x] = 'L';
                while (l < r) {
                    if (l >= left) chars[l++] = 'R';
                    if (r >= left) chars[r--] = 'L';
                }
                if (i == chars.length - 1 && r < left && l >= left) while (l <= i) chars[l++] = 'R';
                pos = i + 1;
            }
        }
        return new String(chars);
    }

}
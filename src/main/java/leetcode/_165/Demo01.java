package leetcode._165;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(compareVersion("1", "1.1"));
        System.out.println(compareVersion("1.1", "1.01.0"));
    }

    private int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int s = Math.min(s1.length, s2.length);
        for (int i = 0; i < s; i++) {
            int a = Integer.parseInt(s1[i]);
            int b = Integer.parseInt(s2[i]);
            if (a < b) return -1;
            if (a > b) return 1;
        }
        String[] longer = s1.length > s2.length ? s1 : s2;
        for (int i = s; i < longer.length; i++)
            if (Integer.parseInt(longer[i]) != 0)
                return Integer.compare(s1.length, s2.length);
        return 0;
    }
}

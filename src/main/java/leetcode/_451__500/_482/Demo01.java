package leetcode._451__500._482;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

    private String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "");
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - k; i > 0; i -= k) sb.insert(i, "-");
        return sb.toString().toUpperCase();
    }

}
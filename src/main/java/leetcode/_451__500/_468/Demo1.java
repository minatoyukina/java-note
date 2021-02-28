package leetcode._451__500._468;


import org.junit.Test;

public class Demo1 {

    @Test
    public void test() {
        System.out.println(validIPAddress("172.16.254.1."));
        System.out.println(validIPAddress("201:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIPAddress("1e1.4.5.6"));
    }

    private String validIPAddress(String IP) {
        if (IP.endsWith(".") || IP.endsWith(":")) return "Neither";
        try {
            if (isIPv4(IP)) return "IPv4";
            if (isIPv6(IP)) return "IPv6";
        } catch (Exception ignored) {

        }
        return "Neither";
    }

    private boolean isIPv6(String IP) {
        String[] split = IP.split(":");
        if (split.length != 8) return false;
        for (String s : split) {
            if (s.length() > 4 || s.length() == 0) return false;
            char[] chars = s.toCharArray();
            for (char c : chars)
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
        }
        return true;
    }

    private boolean isIPv4(String IP) {
        String[] split = IP.split("\\.");
        if (split.length != 4) return false;
        for (String s : split) {
            if (s.length() > 1 && s.startsWith("0")) return false;
            int i = Integer.parseInt(s);
            if (i > 255) return false;
        }
        return true;
    }


}

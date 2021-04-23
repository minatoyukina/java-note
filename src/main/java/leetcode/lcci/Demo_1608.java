package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1608 {

    @Test
    public void test() {
        System.out.println(numberToWords(1_000_000_000));
        System.out.println(numberToWords(123));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(numberToWords(Integer.MAX_VALUE));
    }

    private String numberToWords(int num) {
        if (num == 0) return "Zero";
        String s = String.valueOf(num);
        String[] dic1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] dic2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] dic3 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] dic4 = {"", "Thousand", "Million", "Billion"};
        int n = s.length() / 3 - (s.length() % 3 == 0 ? 1 : 0);
        int last = s.length(), pre = last - 3;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (pre < 0) pre = 0;
            String sub = s.substring(pre, last);
            if (sub.length() == 1) {
                sb.append(dic1[sub.charAt(0) - '0']).append(" ");
            }
            if (sub.length() == 2) {
                if (sub.charAt(0) == '1') {
                    sb.append(dic2[sub.charAt(1) - '0']).append(sb.toString().endsWith(" ") ? "" : " ");
                } else {
                    sb.append(dic3[sub.charAt(0) - '0']).append(sb.toString().endsWith(" ") ? "" : " ")
                            .append(dic1[sub.charAt(1) - '0']).append(sb.toString().endsWith(" ") ? "" : " ");
                }
            }
            if (sub.length() == 3) {
                if (sub.charAt(0) != '0') {
                    sb.append(dic1[sub.charAt(0) - '0']).append(" Hundred").append(sub.charAt(1) == '0' ? "" : " ");
                }
                if (sub.charAt(1) == '1') {
                    sb.append(dic2[sub.charAt(2) - '0']).append(sb.toString().endsWith(" ") ? "" : " ");
                } else {
                    sb.append(dic3[sub.charAt(1) - '0']).append(sb.toString().endsWith(" ") ? "" : " ")
                            .append(dic1[sub.charAt(2) - '0']).append(sb.toString().endsWith(" ") ? "" : " ");
                }
            }
            if (!sub.replaceAll("0", "").isEmpty()) {
                sb.append(dic4[i]).append(ans.toString().startsWith(" ") ? "" : " ");
                ans.insert(0, sb);
            }
            last = pre;
            pre -= 3;
        }
        return ans.toString().trim();
    }
}

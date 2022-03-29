package leetcode._2001__2050._2024;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(maxConsecutiveAnswers("TTFFTFT", 2));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(max(answerKey, k, true), max(answerKey, k, false));
    }

    public int max(String answerKey, int k, boolean t) {
        int left = 0, right = 0, max = 0, count = 0;
        while (right < answerKey.length()) {
            if (t && answerKey.charAt(right) == 'F') count++;
            if (!t && answerKey.charAt(right) == 'T') count++;
            while (count > k) {
                if (t && answerKey.charAt(left) == 'F') count--;
                if (!t && answerKey.charAt(left) == 'T') count--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}

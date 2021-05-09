package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1005 {

    @Test
    public void test() {
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, ""));
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }

    private int findString(String[] words, String s) {
        if (s.isEmpty()) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].isEmpty()) return i;
            }
            return -1;
        }
        int left = 0, right = words.length - 1;
        while (left <= right) {
            if (left == right) return words[left].equals(s) ? left : -1;
            int mid = (left + right) / 2;
            while (words[mid].isEmpty() && mid > left) mid--;
            if (words[mid].compareTo(s) > 0) right = mid;
            else if (words[mid].compareTo(s) == 0) return mid;
            else left = mid + 1;
        }
        return left;
    }
}

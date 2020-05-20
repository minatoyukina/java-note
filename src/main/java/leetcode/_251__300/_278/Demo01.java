package leetcode._251__300._278;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion(2126753390));
    }

    private int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (isBadVersion(middle)) high = middle;
            else low = middle + 1;
        }
        return low;
    }

    private boolean isBadVersion(int n) {
        return n >= 4;
    }

}

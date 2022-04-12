package leetcode._2101__2150._2105;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5));
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1, count = 0, ca = capacityA, cb = capacityB;
        while (left < right) {
            if (ca < plants[left]) {
                count++;
                ca = capacityA - plants[left++];
            } else ca -= plants[left++];
            if (cb < plants[right]) {
                count++;
                cb = capacityB - plants[right--];
            } else cb -= plants[right--];
        }
        if (left > right) return count;
        return Math.max(ca, cb) >= plants[left] ? count : count + 1;
    }

}

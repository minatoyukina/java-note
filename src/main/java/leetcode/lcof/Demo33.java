package leetcode.lcof;

import org.junit.Test;

public class Demo33 {

    @Test
    public void test() {
        System.out.println(verifyPostorder(new int[]{1, 4, 3, 5}));
        System.out.println(verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    private boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] order, int left, int right) {
        if (right < 0 || left >= right) return true;
        int root = order[right];
        int x = left;
        while (x <= right && order[x] <= root) x++;
        if (x - 1 == right) return dfs(order, left, right - 1);
        for (int i = x; i < right; i++) if (order[i] < root) return false;
        return dfs(order, left, x - 1) && dfs(order, x, right - 1);
    }
}

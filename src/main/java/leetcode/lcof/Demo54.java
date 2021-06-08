package leetcode.lcof;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo54 {

    @Test
    public void test() {
        System.out.println(kthLargest(Common.arrayToTree(3, 1, 4, null, 2), 1));
        System.out.println(kthLargest(Common.arrayToTree(3, 1, 4, null, 2), 2));
    }

    private int kthLargest(TreeNode root, int k) {
        x = 0;
        try {
            dfs(root, k);
        } catch (Exception ignored) {
        }
        return ans;
    }

    private int x;
    private int ans;

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        if (++x == k) {
            ans = root.val;
            throw new RuntimeException();
        }
        dfs(root.left, k);
    }
}

package leetcode._101__150._111;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5)))));
        System.out.println(minDepth(treeNode));
    }

    private int minDepth(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[]{Integer.MAX_VALUE};
        dfs(root, 0, ans);
        return ans[0];
    }

    private void dfs(TreeNode root, int level, int[] ans) {
        if (root != null) {
            if (root.left == null && root.right == null)
                ans[0] = Math.min(ans[0], level + 1);
            dfs(root.left, level + 1, ans);
            dfs(root.right, level + 1, ans);
        }
    }

}

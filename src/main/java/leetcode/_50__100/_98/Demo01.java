package leetcode._50__100._98;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(isValidBST(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }

    private boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.left.val >= root.val) return false;
            if (root.right != null && root.right.val <= root.val) return false;
            return isValidBST(root.left) && root.val > dfs(root.left, (long) root.val - 1, true)
                    && isValidBST(root.right) && root.val < dfs(root.right, (long) root.val + 1, false);
        }
        return true;
    }

    private long dfs(TreeNode root, long n, boolean max) {
        if (root != null) {
            n = max ? Math.max(n, root.val) : Math.min(n, root.val);
            return max ? Math.max(dfs(root.left, n, true), dfs(root.right, n, true))
                    : Math.min(dfs(root.left, n, false), dfs(root.right, n, false));
        }
        return n;
    }

}

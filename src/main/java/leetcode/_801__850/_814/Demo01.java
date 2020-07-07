package leetcode._801__850._814;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pruneTree(new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(0)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1))
        )));
    }

    private TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            if (isOrphan(root.left) && root.left.val == 0) {
                root.left = null;
            }
            if (isOrphan(root.right) && root.right.val == 0) {
                root.right = null;
            }
        }
    }

    private boolean isOrphan(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}

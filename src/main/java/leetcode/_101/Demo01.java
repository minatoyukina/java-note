package leetcode._101;

import leetcode._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1, null, null)));
    }

    private boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        return isSymmetric(left, right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return true;
    }
}

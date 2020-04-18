package leetcode._101__150._110;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), new TreeNode(1)),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(isBalanced(treeNode));
    }

    private boolean isBalanced(TreeNode root) {
        if (root != null) {
            if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
            else return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }

    private int height(TreeNode root) {
        if (root != null) return Math.max(height(root.left), height(root.right)) + 1;
        return 0;
    }
}

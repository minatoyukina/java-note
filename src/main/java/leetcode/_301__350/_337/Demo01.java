package leetcode._301__350._337;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(rob(Common.arrayToTree(3, 2, 3, null, 3, null, 1)));
        System.out.println(rob(Common.arrayToTree(3, 4, 5, 1, 3, null, 1)));
    }

    private int rob(TreeNode root) {
        return max(root, 0);
    }

    private int max(TreeNode root, int base) {
        if (root == null) return 0;
        if (base == -1) return max(root.left, 0) + max(root.right, 0);
        return Math.max(
                max(root.left, -1) + max(root.right, -1) + root.val,
                max(root.left, 0) + max(root.right, 0));
    }

}
package leetcode._101__150._124;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxPathSum(Common.arrayToTree(-10, 9, 20, null, null, 15, 7)));
        System.out.println(maxPathSum(Common.arrayToTree(-2, -1)));
    }

    private int max;

    private int maxPathSum(TreeNode root) {
        max = root.val;
        int dfs = dfs(root);
        return Math.max(max, dfs);
    }

    private int dfs(TreeNode root) {
        max = Math.max(max, root.val);
        if (root.left == null && root.right == null) return root.val;
        else if (root.left == null) {
            int right = dfs(root.right);
            max = Math.max(max, root.val + right);
            return Math.max(root.val, root.val + right);
        } else if (root.right == null) {
            int left = dfs(root.left);
            max = Math.max(max, root.val + left);
            return Math.max(root.val, root.val + left);
        } else {
            int left = dfs(root.left);
            int right = dfs(root.right);
            max = Math.max(max, Math.max(root.val + left + right, Math.max(root.val + left, root.val + right)));
            return Math.max(root.val, root.val + Math.max(left, right));
        }
    }
}
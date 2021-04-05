package leetcode._551__600._563;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTilt(Common.arrayToTree(4, 2, 9, 3, 5, null, 7)));
    }

    private int sum;

    private int findTilt(TreeNode root) {
        dfs(root);
        return sum;

    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        sum += Math.abs(sum(root.left) - sum(root.right));
        dfs(root.left);
        dfs(root.right);
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

}
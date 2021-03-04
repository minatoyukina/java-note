package leetcode._501__550._538;

import leetcode._50__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        TreeNode treeNode = convertBST(Common.arrayToTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        System.out.println(Common.treeToList(treeNode));
    }

    private int sum;

    private TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
        }
    }

}

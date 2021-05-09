package leetcode._851__900._897;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(increasingBST(Common.arrayToTree(2, 1, 4, null, null, 3)));
        System.out.println(increasingBST(Common.arrayToTree(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)));
    }

    private TreeNode ans;
    private TreeNode tmp;


    private TreeNode increasingBST(TreeNode root) {
        dfs(root);
        tmp.left = null;
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (ans == null) {
            ans = root;
            tmp = ans;
        } else {
            tmp.left = null;
            tmp.right = root;
            tmp = tmp.right;
        }
        dfs(root.right);
    }

}
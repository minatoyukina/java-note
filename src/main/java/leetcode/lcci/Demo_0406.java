package leetcode.lcci;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0406 {

    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        TreeNode node = new TreeNode(5,
                new TreeNode(3, new TreeNode(2, p), new TreeNode(4)),
                new TreeNode(6));
        System.out.println(inorderSuccessor(node, p));
    }

    private boolean flag;
    private TreeNode ans;

    private TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.left, p);
        if (flag && ans == null) {
            ans = root;
            return;
        }
        if (root == p) flag = true;
        dfs(root.right, p);
    }

}

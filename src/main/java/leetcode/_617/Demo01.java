package leetcode._617;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(mergeTrees(
                new TreeNode(1,
                        new TreeNode(3, new TreeNode(5)),
                        new TreeNode(2)),
                new TreeNode(2,
                        new TreeNode(1, null, new TreeNode(4)),
                        new TreeNode(3, null, new TreeNode(7)))));
    }

    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode node = new TreeNode(0);
        dfs(t1, t2, node, 0);
        return node;
    }

    private void dfs(TreeNode t1, TreeNode t2, TreeNode node, int i) {
        TreeNode tmp = new TreeNode(0);
        if (t1 != null || t2 != null) {
            if (t1 == null) t1 = tmp;
            else if (t2 == null) t2 = tmp;
            tmp.val = t1.val + t2.val;
            if (i == 0) {
                node.val = tmp.val;
                dfs(t1.left, t2.left, node, 1);
                dfs(t1.right, t2.right, node, 2);
            } else {
                if (i == 1) node.left = tmp;
                if (i == 2) node.right = tmp;
                dfs(t1.left, t2.left, tmp, 1);
                dfs(t1.right, t2.right, tmp, 2);
            }
        }
    }


}

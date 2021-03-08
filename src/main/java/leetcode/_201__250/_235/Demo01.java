package leetcode._201__250._235;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        TreeNode p = new TreeNode(2,
                new TreeNode(0),
                null);
        TreeNode q = new TreeNode(4, new TreeNode(3), p);
        System.out.println(lowestCommonAncestor(
                new TreeNode(6,
                        null,
                        new TreeNode(8, q, null)),
                p, q
        ));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        dfs(root, p, l1);
        dfs(root, q, l2);
        for (TreeNode node1 : l1) {
            for (TreeNode node2 : l2) {
                if (node1 == node2) return node1;
            }
        }
        return root;
    }

    private void dfs(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root != null) {
            dfs(root.left, p, list);
            dfs(root.right, p, list);
            if (list.contains(root.left) || list.contains(root.right) || root == p) list.add(root);
        }
    }

}

package leetcode._51__100._95;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(generateTrees(5));
    }

    private List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) return list;
        if (n == 1) {
            TreeNode root = new TreeNode(1);
            list.add(root);
            return list;
        }
        for (int i = 1; i <= n; i++) {
            List<TreeNode> left = generateTrees(i - 1);
            List<TreeNode> right = generateTrees(n - i);
            for (TreeNode node : right) {
                dfs(node, i);
            }
            if (left.isEmpty()) {
                for (TreeNode aRight : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = copy(aRight);
                    list.add(root);
                }
            }
            for (TreeNode aLeft : left) {
                if (right.isEmpty()) {
                    TreeNode root = new TreeNode(i);
                    root.left = copy(aLeft);
                    list.add(root);
                }
                for (TreeNode aRight : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = copy(aLeft);
                    root.right = copy(aRight);
                    list.add(root);
                }
            }
        }
        return list;
    }

    private TreeNode copy(TreeNode root) {
        if (root != null) {
            TreeNode node = new TreeNode(root.val);
            node.left = copy(root.left);
            node.right = copy(root.right);
            return node;
        }
        return null;
    }

    private void dfs(TreeNode root, int i) {
        if (root != null) {
            root.val += i;
            dfs(root.left, i);
            dfs(root.right, i);
        }
    }

}

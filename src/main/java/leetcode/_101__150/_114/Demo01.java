package leetcode._101__150._114;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        TreeNode treeNode = Common.arrayToTree(1, 2, 5, 3, 4, null, 6);
        flatten(treeNode);
        System.out.println(treeNode);

        TreeNode treeNode2 = Common.arrayToTree(4, 2, 6, 1, 3, 5, 7);
        flatten(treeNode2);
        System.out.println(treeNode2);

        TreeNode treeNode3 = Common.arrayToTree(1, null, 2, 3);
        flatten(treeNode3);
        System.out.println(treeNode3);
    }

    private Stack<TreeNode> stack;


    private void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        stack = new Stack<>();
        dfs(root);
        while (!stack.isEmpty()) {
            root.left = null;
            root.right = stack.pop();
            root = root.right;
        }
    }


    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            dfs(root.left);
            stack.push(root);
        }
    }
}

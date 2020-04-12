package leetcode._50__100._94;

import leetcode._100.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(inorderTraversal(new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6, new TreeNode(5), new TreeNode(7)))));
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            if (root.left != null)
                dfs(root.left, list);
            list.add(root.val);
            if (root.right != null)
                dfs(root.right, list);
        }
    }
}

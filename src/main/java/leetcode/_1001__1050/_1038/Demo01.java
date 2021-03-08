package leetcode._1038;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        TreeNode node = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5),
                        new TreeNode(7, null, new TreeNode(8))));
        System.out.println(bstToGst(node));
    }

    private int pre;


    private TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode head) {
        if (head != null) {
            dfs(head.right);
            pre += head.val;
            head.val = pre;
            dfs(head.left);
        }
    }
}

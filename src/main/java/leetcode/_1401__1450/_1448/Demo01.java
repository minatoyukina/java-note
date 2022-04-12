package leetcode._1401__1450._1448;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(goodNodes(Common.arrayToTree(3, 1, 4, 3, null, 1, 5)));
        System.out.println(goodNodes(Common.arrayToTree(3, 3, null, 4, 2)));
    }

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private int count;

    private void dfs(TreeNode node, int pre) {
        if (node == null) return;
        if (node.val >= pre) count++;
        pre = Math.max(node.val, pre);
        dfs(node.left, pre);
        dfs(node.right, pre);
    }

}
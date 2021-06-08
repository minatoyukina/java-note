package leetcode.lcof;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

public class Demo07 {

    @Test
    public void test() {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int root, int left, int right) {
        if (left > right) return null;
        int pivot = preorder[root];
        TreeNode node = new TreeNode(pivot);
        int i = left;
        while (i < right && preorder[root] != inorder[i]) i++;
        node.left = dfs(preorder, inorder, root + 1, left, i - 1);
        node.right = dfs(preorder, inorder, root + 1 + i - left, i + 1, right);
        return node;
    }
}

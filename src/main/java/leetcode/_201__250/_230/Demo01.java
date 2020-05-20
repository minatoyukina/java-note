package leetcode._201__250._230;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

public class Demo01 {

    private int k;
    private int ans;

    @Test
    public void test() {
        System.out.println(kthSmallest(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)), 1));
        System.out.println(kthSmallest(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)), 4));
    }

    private int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallest(root);
        return ans;
    }

    private void kthSmallest(TreeNode root) {
        if (root != null && k >= 0) {
            kthSmallest(root.left);
            if (0 == --k) ans = root.val;
            kthSmallest(root.right);
        }
    }
}

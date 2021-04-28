package leetcode.lcci;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0412 {

    @Test
    public void test() {
        System.out.println(pathSum(Common.arrayToTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
        System.out.println(pathSum(Common.arrayToTree(4, 2, 6, 1, 3, 5, 7), 5));
    }

    private int sum;
    private int count;

    private int pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return count;
    }

    private void helper(TreeNode root, int target) {
        if (root == null) return;
        dfs(root, target);
        helper(root.left, target);
        helper(root.right, target);
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        sum += root.val;
        if (sum == target) count++;
        dfs(root.left, target);
        dfs(root.right, target);
        sum -= root.val;
    }

}

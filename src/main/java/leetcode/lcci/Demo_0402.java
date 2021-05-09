package leetcode.lcci;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0402 {

    @Test
    public void test() {
        System.out.println(sortedArrayToBST(new int[]{}));
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }


    private TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left >= right) return null;
        int p = (left + right) / 2;
        TreeNode node = new TreeNode(nums[p]);
        node.left = dfs(nums, left, p);
        node.right = dfs(nums, p + 1, right);
        return node;
    }

}

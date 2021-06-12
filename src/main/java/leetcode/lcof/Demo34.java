package leetcode.lcof;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo34 {

    @Test
    public void test() {
        System.out.println(pathSum(Common.arrayToTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
        System.out.println(pathSum(Common.arrayToTree(1, -2, -3, 1, 3, -2, null, -1), 2));
    }


    private List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), target, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> current, int target, int sum, List<List<Integer>> ans) {
        if (root == null) return;
        current.add(root.val);
        int index = current.size() - 1;
        if (root.val + sum == target && root.left == null && root.right == null) ans.add(new ArrayList<>(current));
        dfs(root.left, current, target, sum + root.val, ans);
        dfs(root.right, current, target, sum + root.val, ans);
        current.remove(index);
    }
}

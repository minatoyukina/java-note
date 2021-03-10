package leetcode._101__150._113;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(pathSum(treeNode, 22));
        System.out.println(pathSum(treeNode, 0));
    }

    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), root, 0, sum);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> sub, TreeNode root, int sum, int target) {
        if (root != null) {
            if (root.left == null && root.right == null && root.val + sum == target) {
                sub.add(root.val);
                list.add(sub);
            } else {
                sub.add(root.val);
                sum += root.val;
                dfs(list, new ArrayList<>(sub), root.left, sum, target);
                dfs(list, new ArrayList<>(sub), root.right, sum, target);
            }
        }
    }
}

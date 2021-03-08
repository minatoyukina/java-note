package leetcode._651__700._654;

import leetcode._51__100._100.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));

    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        TreeNode root = new TreeNode(max);
        dfs(root, list);
        return root;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            int i = list.indexOf(root.val);
            if (i == -1) return;
            List<Integer> left = list.subList(0, i);
            List<Integer> right = list.subList(i + 1, list.size());
            Integer leftM = left.stream().max(Integer::compareTo).orElse(null);
            Integer rightM = right.stream().max(Integer::compareTo).orElse(null);
            if (leftM != null) {
                root.left = new TreeNode(leftM);
                dfs(root.left, left);
            }
            if (rightM != null) {
                root.right = new TreeNode(rightM);
                dfs(root.right, right);
            }
        }
    }
}

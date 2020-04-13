package leetcode._108;

import leetcode._100.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(sortedArrayToBST(new int[]{1}));
    }

    private TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (collect.size() == 0) return null;
        TreeNode root = new TreeNode(collect.get(collect.size() / 2));
        collect.remove(collect.size() / 2);
        dfs(root, collect);
        return root;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        int middle = list.size() % 2 == 0 ? list.size() / 2 : list.size() / 2 + 1;
        List<Integer> left = new LinkedList<>(list.subList(0, middle));
        List<Integer> right = new LinkedList<>(list.subList(middle, list.size()));
        if (left.size() > 0) {
            root.left = new TreeNode(left.get(left.size() / 2));
            left.remove(left.size() / 2);
            dfs(root.left, left);
        }
        if (right.size() > 0) {
            root.right = new TreeNode(right.get(right.size() / 2));
            right.remove(right.size() / 2);
            dfs(root.right, right);
        }
    }
}

package leetcode._501__550._501;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findMode(Common.arrayToTree(2, 1, 2))));
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        Integer max = map.values().stream().max(Integer::compareTo).orElse(0);
        return map.entrySet().stream().filter(x -> Objects.equals(x.getValue(), max)).mapToInt(Map.Entry::getKey).toArray();
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }

}
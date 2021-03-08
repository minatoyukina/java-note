package leetcode._951__1000._987;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(verticalTraversal(Common.arrayToTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }


    private List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        dfs(root, 0, 0, map);
        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(s -> s.getValue().entrySet().stream()
                        .sorted(Comparator.comparingInt(Map.Entry::getKey))
                        .map(t -> {
                            List<Integer> value = t.getValue();
                            Collections.sort(value);
                            return value;
                        }).reduce((x, y) -> {
                            x.addAll(y);
                            return x;
                        }).orElse(new ArrayList<>())
                ).collect(Collectors.toList());
    }

    private void dfs(TreeNode root, int offset, int level, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root != null) {
            Map<Integer, List<Integer>> listMap = map.get(offset);
            if (listMap == null) listMap = new HashMap<>();
            List<Integer> list = listMap.get(level);
            if (list == null) list = new ArrayList<>();
            list.add(root.val);
            listMap.put(level, list);
            map.put(offset, listMap);
            dfs(root.left, offset - 1, level + 1, map);
            dfs(root.right, offset + 1, level + 1, map);
        }
    }
}

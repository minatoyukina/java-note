package leetcode._101__150._133;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {

        System.out.println();
    }

    private Node cloneGraph(Node node) {

        return node;
    }

    private void dfs(Node node, Set<Node> set) {
        set.add(node);
        Node copy = new Node(node.val);
        List<Node> list = new ArrayList<>();
        copy.neighbors = list;
        if (!node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                if (set.contains(neighbor)) {
                    dfs(neighbor, set);
                }
            }
        }
    }
}

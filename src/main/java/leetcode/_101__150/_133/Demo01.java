package leetcode._101__150._133;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();
        ArrayList<Node> l3 = new ArrayList<>();
        ArrayList<Node> l4 = new ArrayList<>();
        Node a = new Node(1, l1);
        Node b = new Node(2, l2);
        Node c = new Node(3, l3);
        Node d = new Node(4, l4);
        l1.add(b);
        l1.add(d);
        l2.add(a);
        l2.add(c);
        l3.add(b);
        l3.add(d);
        l4.add(a);
        l4.add(c);
        System.out.println(cloneGraph(a).neighbors.get(0).val);

    }

    private Node cloneGraph(Node node) {
        if (node == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node first = queue.pollFirst();
            assert first != null;
            for (Node neighbor : first.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(first).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

}

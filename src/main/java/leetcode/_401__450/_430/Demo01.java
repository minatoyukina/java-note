package leetcode._401__450._430;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        Node node = new Node(0);
        node.next = new Node(1);
        node.child = new Node(2);
        System.out.println(flatten(node));
    }

    public Node flatten(Node head) {
        List<List<Node>> list = new ArrayList<>();
        dfs(head, 0, 0, list);
        Node dummy = new Node();
        Node tmp = dummy;
        int max = list.stream().mapToInt(List::size).max().orElse(0);
        for (int i = 0; i < max; i++) {
            for (List<Node> nodes : list) {
                if (nodes.size() > i && nodes.get(i) != null) {
                    Node copy = new Node();
                    copy.val = nodes.get(i).val;
                    tmp.next = copy;
                    tmp = tmp.next;
                }
            }
        }
        return dummy.next;
    }

    private void dfs(Node head, int level, int pos, List<List<Node>> list) {
        if (head == null) return;
        if (list.size() <= level) {
            List<Node> sub = new ArrayList<>();
            for (int i = 0; i < pos; i++) sub.add(null);
            list.add(sub);
        }
        list.get(level).add(head);
        if (head.child != null) dfs(head.child, level + 1, pos, list);
        if (head.next != null) dfs(head.next, level, pos + 1, list);
    }

    @SuppressWarnings("all")
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}
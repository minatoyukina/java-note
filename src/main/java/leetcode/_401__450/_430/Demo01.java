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
        Node flatten = flatten(node);
        System.out.println(flatten);
    }

    public Node flatten(Node head) {
        List<Integer> list = new ArrayList<>();
        dfs(head, list);
        Node dummy = new Node();
        Node tmp = dummy;
        for (Integer integer : list) {
            Node node = new Node();
            node.val = integer;
            tmp.next = node;
            node.prev = tmp;
            tmp = tmp.next;
        }
        if (dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }

    private void dfs(Node head, List<Integer> list) {
        if (head == null) return;
        list.add(head.val);
        if (head.child != null) dfs(head.child, list);
        if (head.next != null) dfs(head.next, list);
    }

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

    }


}
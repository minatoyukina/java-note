package leetcode.lcof;

import org.junit.Test;

public class Demo35 {

    @SuppressWarnings("all")
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    @Test
    public void test() {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        a.random = b;
        b.random = b;
        System.out.println(copyRandomList(a));
        System.out.println(copyRandomList(null));
    }


    private Node copyRandomList(Node head) {
        Node copy = copy(head);
        Node t1 = head;
        Node t2 = copy;
        while (t1 != null) {
            copyRandom(head, copy, t1.random, t2);
            t1 = t1.next;
            t2 = t2.next;
        }
        return copy;
    }

    private Node copy(Node head) {
        if (head == null) return null;
        Node node = new Node(head.val);
        node.next = copy(head.next);
        return node;
    }

    private void copyRandom(Node head, Node copy, Node random, Node current) {
        if (head == null || random == null) return;
        Node t1 = head;
        Node t2 = copy;
        while (t1 != null) {
            if (t1 == random) {
                current.random = t2;
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
    }
}

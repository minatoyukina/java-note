package leetcode._707;

public class MyLinkedList {

    private Node node;

    private class Node {
        private int val;
        private Node next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        System.out.println(linkedList);
        linkedList.addAtHead(2);
        System.out.println(linkedList);
        linkedList.addAtHead(1);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(1);
        linkedList.deleteAtIndex(2);
        System.out.println(linkedList);
        linkedList.addAtIndex(2, 4);
        linkedList.addAtIndex(0, 0);
        System.out.println(linkedList);
    }

    private MyLinkedList() {

    }

    public int get(int index) {
        Node tmp = this.node;
        while (tmp != null) {
            if (index == 0) return tmp.val;
            tmp = tmp.next;
            index--;
        }
        return -1;
    }

    private void addAtHead(int val) {
        Node node = new Node();
        node.val = val;
        node.next = this.node;
        this.node = node;
    }

    private void addAtTail(int val) {
        Node node = new Node();
        node.val = val;
        Node tmp = this.node;
        if (tmp != null) {
            while (tmp.next != null) tmp = tmp.next;
            tmp.next = node;
        } else this.node = node;

    }

    private void addAtIndex(int index, int val) {
        Node tmp = this.node;
        Node node = new Node();
        node.val = val;
        Node next;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        while (tmp != null) {
            if (--index == 0) {
                next = tmp.next;
                node.next = next;
                tmp.next = node;
                return;
            }
            tmp = tmp.next;
        }
    }

    private void deleteAtIndex(int index) {
        Node tmp = this.node;
        Node next;
        if (index == 0) {
            if (this.node != null) {
                this.node = this.node.next;
                return;
            }
        }
        while (tmp != null) {
            if (--index == 0) {
                if (tmp.next != null) {
                    next = tmp.next.next;
                    tmp.next = next;
                    return;
                }
            }
            tmp = tmp.next;
        }
    }

    @Override
    public String toString() {
        Node tmp = this.node;
        StringBuilder sb = new StringBuilder();
        while (tmp != null) {
            sb.append(tmp.val).append(",");
            tmp = tmp.next;
        }
        return sb.toString().endsWith(",") ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}

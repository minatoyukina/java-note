package leetcode._1201__1250._1206;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(2));
    }

    @SuppressWarnings("all")
    class Skiplist {

        class Node {
            Integer val;
            Node[] next;

            Node(Integer val, int size) {
                this.val = val;
                next = new Node[size];
            }
        }

        private int DEFAULT_MAX_LEVEL = 32;
        private double DEFAULT_P_FACTOR = 0.25;
        private Node head = new Node(null, DEFAULT_MAX_LEVEL);
        private int currentLevel = 1;

        public Skiplist() {

        }

        private int randomLevel() {
            int level = 1;
            while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) level++;
            return level;
        }

        public boolean search(int target) {
            Node node = head;
            for (int i = currentLevel - 1; i >= 0; i--) {
                node = findClosest(node, i, target);
                if (node.next[i] != null && node.next[i].val == target) return true;
            }
            return false;
        }

        public void add(int num) {
            int level = randomLevel();
            Node updateNode = head;
            Node newNode = new Node(num, level);
            for (int i = currentLevel - 1; i >= 0; i--) {
                updateNode = findClosest(updateNode, i, num);
                if (i < level) {
                    if (updateNode.next[i] == null) updateNode.next[i] = newNode;
                    else {
                        Node tmp = updateNode.next[i];
                        updateNode.next[i] = newNode;
                        newNode.next[i] = tmp;
                    }
                }
            }
            if (level > currentLevel) {
                for (int i = currentLevel; i < level; i++) head.next[i] = newNode;
                currentLevel = level;
            }
        }

        private Node findClosest(Node node, int levelIndex, int num) {
            while (node.next[levelIndex] != null && num > node.next[levelIndex].val) node = node.next[levelIndex];
            return node;
        }

        public boolean erase(int num) {
            boolean flag = false;
            Node node = head;
            for (int i = currentLevel - 1; i >= 0; i--) {
                node = findClosest(node, i, num);
                if (node.next[i] != null && node.next[i].val == num) {
                    node.next[i] = node.next[i].next[i];
                    flag = true;
                }
            }
            return flag;
        }
    }

}
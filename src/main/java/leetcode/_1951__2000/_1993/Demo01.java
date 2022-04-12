package leetcode._1951__2000._1993;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree.lock(2, 2));    // 返回 true ，因为节点 2 未上锁。
        System.out.println(lockingTree.unlock(2, 3));  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        System.out.println(lockingTree.unlock(2, 2));  // 返回 true ，因为节点 2 之前被用户 2 上锁。
        System.out.println(lockingTree.lock(4, 5));    // 返回 true ，因为节点 4 未上锁。
        System.out.println(lockingTree.upgrade(0, 1)); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
        System.out.println(lockingTree.lock(0, 1));    // 返回 false ，因为节点 0 已经被上锁了。
    }

    static class LockingTree {

        private final Tree[] trees;

        public LockingTree(int[] parent) {
            Tree tree = new Tree(0);
            trees = new Tree[parent.length];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < parent.length; i++) map.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                Tree poll = queue.poll();
                trees[poll.num] = poll;
                List<Integer> list = map.getOrDefault(poll.num, Collections.emptyList());
                for (Integer integer : list) {
                    Tree child = new Tree(integer);
                    child.parent = poll;
                    poll.children.add(child);
                    queue.add(child);
                }
            }
        }

        public boolean lock(int num, int user) {
            Tree tree = trees[num];
            if (tree.isLocked) return false;
            tree.lockedBy = user;
            return tree.isLocked = true;
        }

        public boolean unlock(int num, int user) {
            Tree tree = trees[num];
            if (!tree.isLocked || tree.lockedBy != user) return false;
            tree.isLocked = false;
            return true;
        }

        public boolean upgrade(int num, int user) {
            Tree tree = trees[num];
            Tree tmp = tree;
            while (tmp != null) {
                if (tmp.isLocked) return false;
                tmp = tmp.parent;
            }
            if (!anyLocked(tree)) return false;
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                Tree poll = queue.poll();
                poll.isLocked = false;
                queue.addAll(poll.children);
            }
            tree.isLocked = true;
            tree.lockedBy = user;
            return true;
        }

        private boolean anyLocked(Tree tree) {
            if (tree == null) return false;
            if (tree.isLocked) return true;
            for (Tree child : tree.children) if (anyLocked(child)) return true;
            return false;
        }

        private static class Tree {
            int num;
            List<Tree> children = new ArrayList<>();
            Tree parent;
            boolean isLocked;
            int lockedBy;

            public Tree(int num) {
                this.num = num;
            }
        }
    }

}
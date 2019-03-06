package data_structure.binarytree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class AVLIterator<K, V> implements Iterator<AVLEntry<K, V>> {
    private Stack<AVLEntry<K, V>> stack;

    public AVLIterator(AVLEntry<K, V> root) {
        stack = new Stack<>();
        addLeftPath(root);
    }

    private void addLeftPath(AVLEntry<K, V> p) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    @Override
    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    @Override
    public AVLEntry<K, V> next() {
        AVLEntry<K, V> p = stack.pop();
        addLeftPath(p.right);
        return p;
    }

    @Override
    public void remove() {
        throw new ConcurrentModificationException("can't not remove");
    }
}

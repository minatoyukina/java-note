package data_structure.adt;

public class AVLTree<T extends Comparable<? super T>> {
    public static class AVLNode<T> {
        T element;
        AVLNode<T> left;
        AVLNode<T> right;
        int height;

        private AVLNode(T element, AVLNode<T> left, AVLNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public AVLNode(T element) {
            this(element, null, null);
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private AVLNode<T> root;

    private AVLTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) throw new NullPointerException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) throw new NullPointerException();
        return findMax(root).element;
    }


    private void insert(T x) {
        root = insert(x, root);
    }

    private void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private boolean contains(T x, AVLNode<T> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else return true;
    }

    private AVLNode<T> findMin(AVLNode<T> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private AVLNode<T> findMax(AVLNode<T> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;
        return t;
    }

    private AVLNode<T> insert(T x, AVLNode<T> t) {
        if (t == null)
            return new AVLNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (x.compareTo(t.left.element) < 0)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (x.compareTo(t.right.element) > 0)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }


    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode<T> rotateWithRightChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.right), height(k2.left)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }

    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AVLNode<T> doubleWithRightChild(AVLNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithLeftChild(k3);
    }

    private void printTree(AVLNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(AVLNode<T> t) {
        return t == null ? -1 : t.height;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(0);
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.printTree();
        System.out.println(avlTree.height(avlTree.root));
        System.out.println(avlTree.root);
    }
}

package data_structure.adt;

@SuppressWarnings("all")
public class BinarySearchTree<T extends Comparable<? super T>> {
    public static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(T element) {
            this(element, null, null);
        }

        @Override
        public String toString() {
            return "BinaryNode{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
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


    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            midOrderPrintTree(root);
    }

    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;
        return t;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        return t;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null)
            return null;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    private void midOrderPrintTree(BinaryNode<T> t) {
        if (t != null) {
            midOrderPrintTree(t.left);
            System.out.print(t.element + " ");
            midOrderPrintTree(t.right);
        }
    }

    private void preOrderPrintTree(BinaryNode<T> t) {
        if (t != null) {
            System.out.print(t.element + " ");
            preOrderPrintTree(t.left);
            preOrderPrintTree(t.right);
        }
    }

    private void postOrderPrintTree(BinaryNode<T> t) {
        if (t != null) {
            postOrderPrintTree(t.left);
            postOrderPrintTree(t.right);
            System.out.print(t.element + " ");
        }
    }

    private void seqOrderPrintTree(BinaryNode<T> t) {
        if (t == null)
            return;
        for (int i = 0; i < height(t)+1; i++) {
            seqOrderPrintTree(t, i);
        }
    }

    private void seqOrderPrintTree(BinaryNode<T> t, int seq) {
        if (t == null)
            return;
        if (seq == 0)
            System.out.print(t.element + " ");
        seqOrderPrintTree(t.left, seq - 1);
        seqOrderPrintTree(t.right, seq - 1);
    }

    private int height(BinaryNode<T> root) {
        if (root == null)
            return -1;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    private BinaryNode invert(BinaryNode root) {
        if (root != null) {
            BinaryNode temp;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
            invert(root.left);
            invert(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert("C");
        binarySearchTree.insert("E");
        binarySearchTree.insert("D");
        binarySearchTree.insert("B");
        binarySearchTree.insert("H");
        binarySearchTree.insert("A");
        binarySearchTree.insert("F");
        binarySearchTree.insert("G");
        BinaryNode<String> root = binarySearchTree.root;
        binarySearchTree.preOrderPrintTree(root);
        System.out.println();
        binarySearchTree.midOrderPrintTree(root);
        System.out.println();
        binarySearchTree.postOrderPrintTree(root);
        System.out.println();
        binarySearchTree.seqOrderPrintTree(root);

    }
}

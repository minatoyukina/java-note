package data_structure.adt;

import java.util.NoSuchElementException;

@SuppressWarnings("all")
public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else break;
        }
        array[hole] = tmp;
    }

    public void insert(T x) {
        if (isFull())
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    private boolean isFull() {
        return currentSize == array.length - 1;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        for (T t : array) {
            t = null;

        }
    }

    public T findMin() {
        if (isEmpty())
            return null;
        return array[1];
    }

    public T deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        T minItem = findMin();
        array[1] = array[currentSize];
        array[currentSize--] = null;
        percolateDown(1);
        return minItem;
    }

    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    private void printHeap() {
        for (T t : array) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        for (int i = 0; i < 20; i++) {
            binaryHeap.insert(i);
        }
//        binaryHeap.deleteMin();
//        binaryHeap.deleteMin();
//        binaryHeap.deleteMin();
        binaryHeap.printHeap();
    }
}

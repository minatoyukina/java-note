package data_structure.sort;

import java.util.Arrays;

public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else break;
        }
        a[i] = tmp;
    }

    public static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int left, int right) {
        AnyType p;
        p = a[left];
        a[left] = a[right];
        a[right] = p;
    }

    private static <T extends Comparable<? super T>> void heapSort(T[] a) {
        for (int i = a.length / 2; i >= 0; i--)
            percDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[4];
        ints[0] = 9;
        ints[1] = 4;
        ints[2] = 11;
        ints[3] = 5;
        Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
        System.out.println();
        heapSort(ints);
        Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
    }
}

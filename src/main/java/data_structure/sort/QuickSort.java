package data_structure.sort;

import java.util.Arrays;

import static data_structure.sort.HeapSort.swapReferences;

public class QuickSort {
    private static final int CUTOFF = 5;

    private static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            swapReferences(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        } else
            InsertSort.insertionSort(a);
    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, center, right);
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    public static void main(String[] args) {
        Integer[] ints = {7, 4, 6, 5, 1, 3, 2};
        Arrays.stream(ints).sorted((x, y) -> (y - x)).forEach(x -> System.out.print(x + " "));
        System.out.println();
        quickSort(ints, 0, 6);
        Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
    }
}

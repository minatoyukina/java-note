package data_structure.sort;

import java.util.Arrays;

public class InsertSort {
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[4];
        ints[0] = 9;
        ints[1] = 4;
        ints[2] = 11;
        ints[3] = 5;
        Arrays.stream(ints).forEach(x->System.out.print(x+" "));
        System.out.println();
        insertionSort(ints);
        Arrays.stream(ints).forEach(x->System.out.print(x+" "));
    }
}

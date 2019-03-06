package data_structure.sort;

import java.util.Arrays;

public class ShellSort {
    private static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < a.length; i++) {
                T tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
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
        shellSort(ints);
        Arrays.stream(ints).forEach(x->System.out.print(x+" "));
    }
}

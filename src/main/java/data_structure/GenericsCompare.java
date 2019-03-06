package data_structure;

import java.util.Comparator;

public class GenericsCompare {
    private static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        String[] arr = {"ZEBRA", "alligator", "crocodile"};
        Integer[] integers={10,2,3};
        System.out.println(findMax(arr, new CaseInsensitiveCompare()));
        System.out.println(findMax(integers,new IntegerCompare()));
    }
}

class CaseInsensitiveCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
//        return o1.compareTo(o2);
    }
}

class IntegerCompare implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

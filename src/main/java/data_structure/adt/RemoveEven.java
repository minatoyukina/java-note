package data_structure.adt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemoveEven {

    private static void removeEven1(List<Integer> list) {
        int i = 0;
        while (i < list.size())
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else i++;
    }

    private static void removeEven2(List<Integer> list) {
        for (Integer x : list) {
            if (x % 2 == 0) {
                list.remove(x);
            }
        }
    }

    private static void removeEven3(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            if (iterator.next() % 2 == 0)
                iterator.remove();
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
//        removeEven1(integers);
//        removeEven2(integers);
        removeEven3(integers);
        System.out.println(integers);
    }
}

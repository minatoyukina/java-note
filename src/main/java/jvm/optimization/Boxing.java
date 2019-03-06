package jvm.optimization;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Boxing {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);

        List list1 = Arrays.asList(new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4)});

        int sum1 = 0;
        for (Iterator localIterator = list1.iterator(); localIterator.hasNext(); ) {
            int i = ((Integer) localIterator.next()).intValue();
            sum1 += i;
        }
        System.out.println(sum1);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);//IntegerCache
        System.out.println(c.equals(a + b));
        System.out.println(c == (a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

//        while (false)
//            System.out.println("balabala");
    }


}

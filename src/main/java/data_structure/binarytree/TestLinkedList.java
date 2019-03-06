package data_structure.binarytree;

import java.util.*;

public class TestLinkedList {
//    @Test
//    public void testQuery(){
//        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
//        System.out.println(list.get(3));
////        System.out.println(list.get(9));
//    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(0,1,2,3,4,5,11,7,8,9));
        List<Integer> list1=new ArrayList<>(Arrays.asList(9,4,6,5,9,7,2));
        System.out.println(list1.get(6));
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(5);
        set.add(7);
        set.add(2);
        set.add(3);
        int binarySearch = Collections.binarySearch(list, 11);
        System.out.println(binarySearch);
//        System.out.println(set);
//        for (Integer integer : set) {
//            System.out.println(integer);
//        }
    }
}

package data_structure.binarytree;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class TestBST {
    private Random random = new Random();
    private final int MAX1 = 16;

    @Test
    public void testPutItr() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i < MAX1; i++) {
            map.put(random.nextInt(MAX1), random.nextInt(MAX1) + "");
        }

        Iterator<AVLEntry<Integer, String>> it = map.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().key + " ");

        }
        for (AVLEntry<Integer, String> integerStringAVLEntry : map) {
//            System.out.println(integerStringAVLEntry.key + "-" + integerStringAVLEntry.value);
            System.out.println(integerStringAVLEntry);
        }
    }
}

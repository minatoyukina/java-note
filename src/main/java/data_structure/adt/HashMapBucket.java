package data_structure.adt;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class HashMapBucket {
    static class A {
//        @Override
//        public int hashCode() {
//            return 42;
//        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Map<A, String> map = new HashMap<>(16,1);
        for (int i = 0; i < 13; i++) {

            map.put(new A(), "abc");
        }
//        map.put(new A(), "def");

        Class<? extends Map> clazz = map.getClass();
        Field table = clazz.getDeclaredField("table");
        table.setAccessible(true);
        Map.Entry<Integer, String>[] realTable = (Map.Entry<Integer, String>[]) table.get(map);
        for (int i = 0; i < realTable.length; i++) {
            System.out.println(String.format("Bucket: %d, Entry: %s", i, bucketToString(realTable[i])));
        }
    }

    private static String bucketToString(Map.Entry<Integer, String> entry) throws Exception {
        if (entry == null)
            return null;
        StringBuilder sb = new StringBuilder();

        Class<? extends Map.Entry> clazz = entry.getClass();
        Field next = clazz.getDeclaredField("next");
        next.setAccessible(true);

        while (entry != null) {
            sb.append(entry);
            entry = (Map.Entry<Integer, String>) next.get(entry);
            if (null != entry)
                sb.append(" -> ");
        }
        return sb.toString();
    }
}

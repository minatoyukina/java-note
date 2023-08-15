package leetcode._801__850._833;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findReplaceString("mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr", new int[]{46, 29, 2, 44, 31, 26, 42, 9, 38, 23, 36, 12, 16, 7, 33, 18}, new String[]{"rym", "kv", "nbzxu", "vx", "js", "tp", "tc", "jta", "zqm", "ya", "uz", "avm", "tz", "wn", "yv", "ird"}, new String[]{"gfhc", "uq", "dntkw", "wql", "s", "dmp", "jqi", "fp", "hs", "aqz", "ix", "jag", "n", "l", "y", "zww"}));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new TreeMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }
        int idx = 0;
        for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
            indices[idx] = entry.getKey();
            sources[idx] = entry.getValue()[0];
            targets[idx++] = entry.getValue()[1];
        }
        List<Integer> list = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            if (s.indexOf(sources[i], indices[i]) == indices[i]) {
                list.add(indices[i]);
                list.add(indices[i] + sources[i].length());
                sub.add(targets[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i = i + 2) {
            if (i == 0) sb.append(s, 0, list.get(i));
            else sb.append(s, list.get(i - 1), list.get(i));
            sb.append(sub.get(i / 2));
        }
        if (sb.length() == 0) return s;
        if (list.get(list.size() - 1) != s.length()) sb.append(s.substring(list.get(list.size() - 1)));
        return sb.toString();
    }

}
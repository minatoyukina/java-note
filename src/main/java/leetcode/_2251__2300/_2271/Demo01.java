package leetcode._2251__2300._2271;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximumWhiteTiles(Common.strToArray("[[10,11],[1,1]]"), 2));
        System.out.println(maximumWhiteTiles(Common.strToArray("[[1,5],[10,11],[12,18],[20,25],[30,32]]"), 10));
    }

    private int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(x -> x[0]));
        TreeMap<Integer, int[]> tree = new TreeMap<>();
        for (int i = 0; i < tiles.length; i++) {
            int[] tile = tiles[i];
            tree.put(tile[0], new int[]{i, tile[1]});
        }
        int[] pre = new int[tiles.length + 1];
        for (int i = 0; i < tiles.length; i++) pre[i + 1] = pre[i] + tiles[i][1] - tiles[i][0] + 1;
        int max = 0;
        for (int i = 0; i < tiles.length; i++) {
            int end = tiles[i][0] + carpetLen;
            Map.Entry<Integer, int[]> entry = tree.lowerEntry(end);
            int[] value = entry.getValue();
            if (value[1] < end) max = Math.max(max, pre[value[0] + 1] - pre[i]);
            else max = Math.max(max, pre[value[0]] - pre[i] + end - entry.getKey());
        }
        return max;
    }


}

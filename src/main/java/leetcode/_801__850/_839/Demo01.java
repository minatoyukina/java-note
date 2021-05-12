package leetcode._801__850._839;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSimilarGroups(new String[]{"ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic",
                "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"}));
    }

    private int numSimilarGroups(String[] strs) {
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    union(arr, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] == i) ans++;
        return ans;
    }

    private boolean check(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (count > 2) return false;
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count == 2 || count == 0;
    }

    private int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        return arr[x] = find(arr, arr[x]);
    }

    private void union(int[] arr, int x, int y) {
        int a = find(arr, x);
        int b = find(arr, y);
        arr[b] = a;
    }

}
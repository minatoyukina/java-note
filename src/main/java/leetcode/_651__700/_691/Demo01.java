package leetcode._651__700._691;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minStickers(new String[]{"and", "pound"}, "quietchord"));
        System.out.println(minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }

    private int minStickers(String[] stickers, String target) {
        for (int i = 0; i < stickers.length; i++) {
            String sticker = stickers[i];
            StringBuilder sb = new StringBuilder(sticker);
            for (int j = sticker.length() - 1; j >= 0; j--)
                if (!target.contains(sticker.charAt(j) + "")) sb.deleteCharAt(j);
            stickers[i] = sb.toString();
        }
        List<String> list = Arrays.stream(stickers).filter(s -> !s.isEmpty()).sorted((x, y) -> y.length() - x.length())
                .collect(Collectors.toList());
        int len = Arrays.stream(target.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
                .mapToInt(Long::intValue).max().orElse(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = list.size() - 1; j > i; j--) {
                if (check(list.get(i), list.get(j))) list.remove(j);
            }
        }
        stickers = list.toArray(new String[0]);
        MIN = Integer.MAX_VALUE;
        int[] arr = new int[26];
        for (int i = 0; i < target.length(); i++) arr[target.charAt(i) - 'a']++;
        dfs(arr, stickers, 0, 0, len);
        return MIN == Integer.MAX_VALUE ? -1 : MIN;
    }

    private int MIN;

    private void dfs(int[] arr, String[] stickers, int pos, int count, int len) {
        if (count >= MIN) return;
        if (Arrays.stream(arr).allMatch(s -> s <= 0)) {
            MIN = count;
            return;
        }
        if (pos >= stickers.length) return;
        String sticker = stickers[pos];
        for (int i = len; i >= 0; i--) {
            helper(arr, i, sticker, false);
            dfs(arr, stickers, pos + 1, count + i, len);
            helper(arr, i, sticker, true);
        }
    }

    private boolean check(String a, String b) {
        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i = 0; i < a.length(); i++) arr1[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++) arr2[b.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) if (arr2[i] > arr1[i]) return false;
        return true;
    }

    private void helper(int[] arr, int times, String s, boolean add) {
        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a'] += add ? times : -times;
    }


}
package leetcode._2401__2450._2424;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        LUPrefix server = new LUPrefix(4);   // 初始化 4个视频的上传流
        server.upload(3);                    // 上传视频 3 。
        System.out.println(server.longest());
        server.upload(1);                    // 上传视频 1 。
        System.out.println(server.longest());
        server.upload(2);                    // 上传视频 2 。
        System.out.println(server.longest());
    }

    static class LUPrefix {

        private TreeMap<Integer, Integer> tree;

        public LUPrefix(int n) {
            tree = new TreeMap<>();
        }

        public void upload(int video) {
            Map.Entry<Integer, Integer> lower = tree.lowerEntry(video), higher = tree.higherEntry(video);
            if (lower != null && lower.getValue() == video - 1) {
                if (higher != null && higher.getKey() == video + 1) {
                    tree.remove(video + 1);
                    tree.put(lower.getKey(), higher.getValue());
                } else tree.put(lower.getKey(), video);
            } else if (higher != null && higher.getKey() == video + 1) {
                tree.remove(video + 1);
                tree.put(video, higher.getValue());
            } else tree.put(video, video);
        }

        public int longest() {
            return tree.getOrDefault(1, 0);
        }
    }

}
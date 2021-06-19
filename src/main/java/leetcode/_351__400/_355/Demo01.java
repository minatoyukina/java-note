package leetcode._351__400._355;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {

    }

    @SuppressWarnings("all")
    class Twitter {

        int id = 0;
        Map<Integer, List<Pair<Integer, Integer>>> tweet = new HashMap<>();
        Map<Integer, Set<Integer>> follow = new HashMap<>();

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            List<Pair<Integer, Integer>> list = tweet.getOrDefault(userId, new ArrayList<>());
            list.add(new Pair<>(++id, tweetId));
            tweet.put(userId, list);
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> set = follow.getOrDefault(userId, new HashSet<>());
            set.add(userId);
            return tweet.entrySet().stream()
                    .filter(s -> set.contains(s.getKey()))
                    .map(Map.Entry::getValue).flatMap(Collection::stream)
                    .sorted((x, y) -> y.getKey() - x.getKey())
                    .limit(10).map(Pair::getValue).collect(Collectors.toList());
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> set = follow.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            follow.put(followerId, set);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = follow.getOrDefault(followerId, new HashSet<>());
            set.remove(followeeId);
            follow.put(followerId, set);
        }
    }

}
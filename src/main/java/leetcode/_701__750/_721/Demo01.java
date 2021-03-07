package leetcode._701__750._721;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
//        System.out.println(accountsMerge(Lists.newArrayList(
//                Lists.newArrayList("John", "johnsmith@mail.com", "john00@mail.com"),
//                Lists.newArrayList("John", "johnnybravo@mail.com"),
//                Lists.newArrayList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
//                Lists.newArrayList("Mary", "mary@mail.com")
//        )));
//        System.out.println(accountsMerge(Lists.newArrayList(
//                Lists.newArrayList("John", "0@mail.com", "1@mail.com"),
//                Lists.newArrayList("John", "3@mail.com", "4@mail.com"),
//                Lists.newArrayList("John", "4@mail.com", "5@mail.com"),
//                Lists.newArrayList("John", "2@mail.com", "3@mail.com"),
//                Lists.newArrayList("John", "1@mail.com", "2@mail.com")
//                , Lists.newArrayList("John", "5@mail.com")
//        )));
        System.out.println(accountsMerge(Lists.newArrayList(
                Lists.newArrayList("Lily", "Lily3@m.co", "Lily4@m.co", "Lily17@m.co"),
                Lists.newArrayList("Lily", "Lily5@m.co", "Lily3@m.co", "Lily23@m.co"),
                Lists.newArrayList("Lily", "Lily0@m.co", "Lily1@m.co", "Lily8@m.co"),
                Lists.newArrayList("Lily", "Lily14@m.co", "Lily23@m.co"),
                Lists.newArrayList("Lily", "Lily4@m.co", "Lily5@m.co", "Lily20@m.co"),
                Lists.newArrayList("Lily", "Lily1@m.co", "Lily2@m.co", "Lily11@m.co"),
                Lists.newArrayList("Lily", "Lily2@m.co", "Lily0@m.co", "Lily14@m.co")
        )));
    }

    private List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            boolean inter = false;
            Integer first = null;
            Integer index = null;
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                Integer tmp = map.get(email);
                if (tmp != null) {
                    if (first == null) first = tmp;
                    else index = tmp;
                    inter = true;
                    List<String> sub = accounts.get(first);
                    if (sub == null) continue;
                    sub.addAll(list.subList(1, list.size()));
                    if (index == null) {
                        for (int k = 1; k < list.size(); k++)
                            map.put(list.get(k), first);
                        if (i != first) accounts.set(i, null);
                    }
                    if (index != null && !index.equals(first)) {
                        sub.addAll(accounts.get(index).subList(1, accounts.get(index).size()));
                        for (int k = 1; k < accounts.get(index).size(); k++)
                            map.put(accounts.get(index).get(k), first);
                        accounts.set(index, null);

                    }
                }
            }
            if (!inter) for (int j = 1; j < list.size(); j++) map.put(list.get(j), i);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            if (account != null && account.size() > 0) {
                List<String> strings = new ArrayList<>();
                strings.add(account.get(0));
                strings.addAll(new ArrayList<>(new TreeSet<>(account.subList(1, account.size()))));
                res.add(strings);
            }
        }
        return res;
    }

}

package leetcode._1551__1600._1600;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        //["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
        //[["king"],["king","andy"],["king","bob"],["king","catherine"],["andy","matthew"],["bob","alex"],["bob","asha"],[null],["bob"],[null]]
        ThroneInheritance inheritance = new ThroneInheritance("king");
        inheritance.birth("king", "andy");
        inheritance.birth("king", "bob");
        inheritance.birth("king", "catherine");
        inheritance.birth("andy", "matthew");
        inheritance.birth("bob", "alex");
        inheritance.birth("bob", "asha");
        System.out.println(inheritance.getInheritanceOrder());
    }

    @SuppressWarnings("all")
    class ThroneInheritance {
        String king;
        Map<String, List<String>> map;
        Map<String, String> parent;
        Set<String> dead;

        public ThroneInheritance(String kingName) {
            king = kingName;
            map = new HashMap<>();
            map.put(kingName, new ArrayList<>());
            parent = new HashMap<>();
            dead = new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            map.get(parentName).add(childName);
            map.put(childName, new ArrayList<>());
            parent.put(childName, parentName);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            Set<String> set = new LinkedHashSet<>();
            String successor = king;
            while (successor != null) {
                set.add(successor);
                successor = successor(successor, set);
            }
            for (String s : dead) set.remove(s);
            return new ArrayList<>(set);
        }

        private String successor(String x, Set<String> curOrder) {
            if (x == null) return null;
            List<String> children = map.get(x);
            if (children.isEmpty() || curOrder.containsAll(children)) return successor(parent.get(x), curOrder);
            else for (String child : children) if (!curOrder.contains(child)) return child;
            return null;
        }
    }

}
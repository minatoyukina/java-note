package leetcode._201__250._208;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        trie.insert("bbba");
        trie.insert("bb");
        trie.insert("bc");
        System.out.println(trie.startsWith("b"));
        System.out.println(trie);
    }

    @Override
    public String toString() {
        return "Trie{" +
                "word=" + word +
                ", isEnd=" + isEnd +
                ", child=" + child +
                '}';
    }

    private char word;
    private boolean isEnd;
    private List<Trie> child;

    public Trie(char word, boolean isEnd, List<Trie> child) {
        this.word = word;
        this.isEnd = isEnd;
        this.child = child;
    }

    public Trie() {
        this(Character.MIN_VALUE, false, new ArrayList<>());
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        List<Trie> list = this.child;
        label:
        for (int i = 0; i < chars.length; i++) {
            for (Trie trie : list) {
                if (trie.word == chars[i]) {
                    if (i == chars.length - 1) trie.isEnd = true;
                    list = trie.child;
                    continue label;
                }
            }
            Trie trie = new Trie(chars[i], i == chars.length - 1, new ArrayList<>());
            list.add(trie);
            list = trie.child;
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        List<Trie> list = this.child;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (Trie trie : list) {
                count++;
                if (trie.word == chars[i]) {
                    list = trie.child;
                    if (i == chars.length - 1 && trie.isEnd) return true;
                    break;
                }
                if (count == list.size()) return false;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        List<Trie> list = this.child;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (Trie trie : list) {
                count++;
                if (trie.word == chars[i]) {
                    list = trie.child;
                    if (i == chars.length - 1) return true;
                    break;
                }
                if (count == list.size()) return false;
            }
        }
        return false;
    }
}

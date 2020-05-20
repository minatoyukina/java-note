package leetcode._201__250._208;

import org.junit.Test;

public class Trie {

    private StringBuilder sb;

    @Test
    public void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public Trie() {
        sb = new StringBuilder();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        sb.append(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return sb.indexOf(word) > -1;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return sb.toString().startsWith(prefix);
    }
}

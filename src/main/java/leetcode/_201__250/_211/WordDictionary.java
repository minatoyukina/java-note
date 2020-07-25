package leetcode._201__250._211;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
class WordDictionary {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("mad");
        dictionary.addWord("dad");
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("c.d"));
    }

    private Set<String> set;
    private Set<Integer> lset;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        set = new HashSet<>();
        lset = new HashSet<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        set.add(word);
        lset.add(word.length());
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (!lset.contains(word.length())) {
            return false;
        }
        if (!word.contains(".")) {
            return set.contains(word);
        }
        if (word.replace(".", "").equals("")) return true;
        for (String s : set) {
            if (s.length() == word.length()) {
                for (int i = 0; i < s.length(); i++) {
                    if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
                        break;
                    }
                    if (i == s.length() - 1) return true;
                }
            }
        }
        return false;
    }
}

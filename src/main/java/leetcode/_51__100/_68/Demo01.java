package leetcode._51__100._68;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20));
    }

    private List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (sb.length() + word.length() <= maxWidth) {
                sb.append(word).append(" ");
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
                i--;
            }
        }
        return list;
    }
}

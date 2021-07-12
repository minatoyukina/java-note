package leetcode._51__100._68;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20));
    }

    private List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (len + word.length() + queue.size() <= maxWidth) {
                queue.offer(word);
                len += word.length();
            } else {
                append(list, queue, maxWidth, len, false);
                len = 0;
                i--;
            }
        }
        append(list, queue, maxWidth, len, true);
        return list;
    }

    private void append(List<String> list, Queue<String> queue, int maxWidth, int len, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        int count = queue.size();
        if (count == 1) {
            sb.append(queue.poll());
            while (maxWidth - sb.length() > 0) sb.append(" ");
            list.add(sb.toString());
            return;
        }
        if (isLast) {
            while (!queue.isEmpty()) sb.append(queue.poll()).append(queue.isEmpty() ? "" : " ");
            while (maxWidth - sb.length() > 0) sb.append(" ");
            list.add(sb.toString());
            return;
        }
        int avg = (maxWidth - len) / (count - 1);
        int remain = maxWidth - len - avg * (count - 1);
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            for (int j = 0; j < avg; j++) sb.append(" ");
            if (remain-- > 0) sb.append(" ");
        }
        list.add(sb.toString().trim());
    }
}

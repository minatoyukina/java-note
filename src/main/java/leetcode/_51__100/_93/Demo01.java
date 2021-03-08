package leetcode._51__100._93;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("155123123123"));
    }

    private List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(s, "12", true);
        while (tokenizer.hasMoreElements()) {
            list.add((String) tokenizer.nextElement());
        }
        return list;
    }
}

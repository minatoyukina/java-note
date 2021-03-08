package leetcode._51__100._71;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(simplifyPath("/usr/local/.././src/"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        System.out.println(simplifyPath("/../"));
    }

    private String simplifyPath(String path) {
        List<String> collect = Arrays.stream(path.split("/"))
                .filter(s -> !s.equals(".") && !s.equals("")).collect(Collectors.toList());
        while (collect.indexOf("..") >= 0) {
            int i = collect.indexOf("..");
            if (i >= 1) {
                collect.remove(i - 1);
                collect.remove(i - 1);
            } else collect.remove(0);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : collect) sb.append("/").append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

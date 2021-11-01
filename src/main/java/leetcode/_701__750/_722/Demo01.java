package leetcode._701__750._722;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(String.join("\n", removeComments(new String[]{"/*Test program */", "int main()",
                "{ ", "  // variable declaration ",
                "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
                "   testing */", "a = b + c;", "}"
        })));
        System.out.println(removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));
    }

    /*  // /*  */ //eee
    public List<String> removeComments(String[] source) {
        String str = String.join("\n", source);
        int i;
        while ((i = str.indexOf("/*")) >= 0) {
            int j = str.indexOf("*/", i);
            str = str.substring(0, i) + str.substring(j + 2);
        }
        return Arrays.stream(str.split("\n"))
                .map(s -> s.substring(0, s.contains("//") ? s.indexOf("//") : s.length()))
                .filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

}
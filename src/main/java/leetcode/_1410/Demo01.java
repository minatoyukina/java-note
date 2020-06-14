package leetcode._1410;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
        System.out.println(entityParser("&amp;gt;"));
    }

    private String entityParser(String text) {
        return text.replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
    }
}

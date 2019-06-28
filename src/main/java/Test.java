import com.google.common.collect.Streams;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java");
        Streams.mapWithIndex(list.stream(), Pair::new).forEach(System.out::println);
    }
}

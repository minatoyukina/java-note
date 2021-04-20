package leetcode.lcci;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0806 {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        hanota(Lists.newArrayList(2, 1, 0), new ArrayList<>(), list);
        System.out.println(list);
    }

    private void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (C.size() == A.size()) return;

    }
}

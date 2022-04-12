package leetcode._1451__1500._1472;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {

    }

    @SuppressWarnings("all")
    static class BrowserHistory {

        private List<String> list = new ArrayList<>();
        private int pos;

        public BrowserHistory(String homepage) {
            list.add(homepage);
        }

        public void visit(String url) {
            list = list.subList(0, pos + 1);
            list.add(url);
            pos = list.size() - 1;
        }

        public String back(int steps) {
            if (steps > pos) pos = 0;
            else pos -= steps;
            return list.get(pos);
        }

        public String forward(int steps) {
            if (pos + steps >= list.size()) pos = list.size() - 1;
            else pos += steps;
            return list.get(pos);
        }
    }
}
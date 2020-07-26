package leetcode._301__350._341;

import java.util.*;

@SuppressWarnings("all")
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        flatten(list, nestedList);
        this.iterator = list.iterator();
    }

    private void flatten(List<Integer> list, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList)
            if (nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
            else flatten(list, nestedInteger.getList());
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

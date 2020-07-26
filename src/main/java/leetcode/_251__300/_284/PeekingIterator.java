package leetcode._251__300._284;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class PeekingIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        PeekingIterator iterator = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
    }

    private List<Integer> list;
    private Iterator<Integer> iterator;
    private int offset;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        iterator.forEachRemaining(s -> list.add(s));
        this.iterator = list.iterator();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(offset);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        offset++;
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

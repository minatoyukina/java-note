package effective_java;

import java.text.ParseException;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 5;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
//        return elements[--size];

        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public static void main(String[] args) throws ParseException {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push("hello");
        stack.push(true);
        stack.push(5);
        stack.push(6);
        System.out.println(Arrays.toString(stack.elements));
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.elements));
        Person.main(args);

    }

}

package lambda.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Apple {
    private int size;
    private String color;

    public static void main(String[] args) {
        BiFunction<Integer, String, Apple> apple1 = Apple::new;
        Apple apply = apple1.apply(1, "red");
        System.out.println(apply);
        Apple apple2 = new Apple(2, "green");
        Supplier<String> getColor = apple2::getColor;
        System.out.println(getColor.get());
        Comparator<Apple> comparator = Comparator.comparingInt(Apple::getSize);
        System.out.println(comparator.compare(apply, apple2));
    }

    public Apple() {
    }

    public Apple(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}

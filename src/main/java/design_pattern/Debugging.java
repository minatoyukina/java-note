package design_pattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Debugging {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).map(Debugging::divideByZero).forEach(System.out::println);

        List<Point> points = Arrays.asList(new Point(12, 3), null);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static int divideByZero(int n) {
        return n / 0;
    }
}

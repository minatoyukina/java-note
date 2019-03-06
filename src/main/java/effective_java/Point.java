package effective_java;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}

class ColorPoint {
    private final Color color;
    private final Point point;

    public ColorPoint(int x, int y, Color color) {
        if (color == null)
            throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp1 = new ColorPoint(1, 2, Color.BLUE);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp1.asPoint()));
        System.out.println(p.equals(cp2.asPoint()));
        System.out.println(cp1.equals(cp2));
        System.out.println(cp1.asPoint().equals(p));
    }

//}class ColorPoint extends Point {
//    private final Color color;
//
//    public ColorPoint(int x, int y, Color color) {
//        super(x, y);
//        this.color = color;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
////        if (!(obj instanceof ColorPoint))
////            return false;
////        return super.equals(obj) && ((ColorPoint) obj).color == color;
//
//        //v2
//        if (!(obj instanceof Point))
//            return false;
//        if (!(obj instanceof ColorPoint))
//            return obj.equals(this);
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }
//
//    public static void main(String[] args) {
//        Point p = new Point(1, 2);
//        ColorPoint cp1 = new ColorPoint(1, 2, Color.BLUE);
//        ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);
//        System.out.println(p.equals(cp1));
//        System.out.println(p.equals(cp2));
//        System.out.println(cp1.equals(cp2));
//        System.out.println(cp1.equals(p));
//    }
//}
}

enum Color {
    RED, BLUE, GREEN
}
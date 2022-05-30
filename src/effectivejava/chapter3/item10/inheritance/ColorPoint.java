package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

//    // Нарушение симметричности<
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof ColorPoint))
//            return false;
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }

    // Нарушение транзитивности

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;

        // Если obj - обычная точка, сравнение не учитывает цвет
        if (!(obj instanceof ColorPoint)) {
            return obj.equals(this);
        }

        // obj - объект ColorPoint; выполняется полное сравнение
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s %n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}

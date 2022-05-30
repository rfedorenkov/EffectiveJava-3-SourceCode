package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Point;

import java.util.Set;

public class CounterPointTest {
    // Инициализация множества unitCircle как содержащего
    // все Point на единичной окружности
    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0), new Point(0, 1),
            new Point(-1, 0), new Point(0, -1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);

        System.out.println(onUnitCircle(p1));

        System.out.println(onUnitCircle(p2));
    }
}
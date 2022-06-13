package effectivejava.chapter9.item61;

import java.util.Comparator;

// Плохой компаратор - можете ли вы указать его слабые места?
public class BrokenComparator {
    public static void main(String[] args) {
//        Comparator<Integer> naturalOrder =
//                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // Исправленный компаратор
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Автораспаковка
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}
package effectivejava.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Параллельное традиционное отображение
// поверх ConcurrentMap
public class Intern {
    // Параллельное традиционное отображение
    // поверх ConcurrentMap - неоптимальный код
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return  previousValue == null ? s : previousValue;
//    }

    // Параллельное традиционное отображение
    // поверх ConcurrentMap - более быстрый код!
    public static String intern(String s) {
        String result = map.get(s);

        if (result == null) {
            result = map.putIfAbsent(s, s);

            if (result == null)
                result = s;
        }
        return result;
    }
}
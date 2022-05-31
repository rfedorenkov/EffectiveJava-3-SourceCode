package effectivejava.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

// Сбой во время выполнения - метод unsafeAdd
// использует несформированный тип (List)!
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Сгенерированное компилятором приведение
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
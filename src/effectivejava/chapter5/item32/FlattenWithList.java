package effectivejava.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// List представляет собой безопасную с точки зрения типов
// альтернативу обобщенному параметру переменной длины
public class FlattenWithList {

    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();

        for (List<? extends T> list : lists)
            result.addAll(list);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7)));
        System.out.println(flatList);
    }
}
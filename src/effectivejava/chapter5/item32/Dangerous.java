package effectivejava.chapter5.item32;

import java.util.List;

// Небезопасно хранить значение в общем параметре массива с переменным количеством.
public class Dangerous {

    // Смесь обобщенных типов и переменного количества
    // аргументов может нарушить безопасность типов!
    static void dangerous(List<String>... stringList) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringList;
        objects[0] = intList; // Загрязнение кучи
        String s = stringList[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
package effectivejava.chapter5.item31;

import java.util.Arrays;
import java.util.List;

// Приватный вспомогательный метод для захвата подстановочных знаков
public class Swap {

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Закрытый вспомогательный метод для захвата символа подстановки
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        // Меняем местами первый и последний аргумент и выводим на экран полученный список
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() -1);
        System.out.println(argList);
    }
}
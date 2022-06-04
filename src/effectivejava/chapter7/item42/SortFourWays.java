package effectivejava.chapter7.item42;

import java.util.*;

import static java.util.Comparator.comparingInt;

// Сортировка с функциональными объектами
public class SortFourWays {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        // Экземпляр анонимного класса в качестве
        // функционального объекта - устарело!
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        // Лямбда-выражение в качестве функционального объекта
        // (замена анонимного класса)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Метод построения компаратора (со ссылкой на метод) вместо лямбды
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        // Метод List.sort по умолчанию в сочетании с методом построения компаратора
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
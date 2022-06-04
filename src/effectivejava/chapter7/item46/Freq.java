package effectivejava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// Примеры таблицы частот, показывающие неправильное и правильное использование потока
public class Freq {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

//        // Использование потокового API, но не потоковой
//        // парадигмы - не делайте так!
//        Map<String, Long> freq = new HashMap<>();
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }

        // Корректное использование потоков для инициализации таблицы частот
        Map<String, Long> freq;

        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);

        // Конвейер для получения первой десятки слов из таблицы частот
        List<String> topTen = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
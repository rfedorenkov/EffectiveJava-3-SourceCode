package effectivejava.chapter7.item45;

import java.util.stream.IntStream;

// Воздержитесь от использования потоков для обработки значений char
public class CharStream {

    public static void main(String[] args) {
        // Не дает ожидаемого результата
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();

        // Исправляем проблему
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
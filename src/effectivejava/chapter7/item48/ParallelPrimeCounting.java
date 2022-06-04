package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {

//    // Конвейер потока для вычисления количества простых
//    // чисел - эффективное использование распараллеливания
//    // Время выполнения - 15 сек
//    static long pi(long n) {
//        return LongStream.range(2, n)
//                .mapToObj(BigInteger::valueOf)
//                .filter(i -> i.isProbablePrime(50))
//                .count();
//    }

    // Конвейер потока для вычисления количества простых
    // чисел - параллельная версия
    // Время выполнения - 2 сек
    static long pi(long n) {
        return LongStream.range(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(pi(10_000_000));
    }
}
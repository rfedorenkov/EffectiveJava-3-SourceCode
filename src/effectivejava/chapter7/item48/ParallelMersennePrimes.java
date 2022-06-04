package effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

// Потоковая программа для генерации первых 20 простых чисел Мерсенна
public class ParallelMersennePrimes {

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
//                .parallel() // программа зависает
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEachOrdered(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
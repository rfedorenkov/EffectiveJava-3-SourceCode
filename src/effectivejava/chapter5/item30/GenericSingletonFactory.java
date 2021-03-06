package effectivejava.chapter5.item30;

import java.util.function.UnaryOperator;

public class GenericSingletonFactory {

    // Проектный шаблон обобщенной фабрики синглтонов
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Пример программы, использующей обобщенный синглтон
    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();

        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();

        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}
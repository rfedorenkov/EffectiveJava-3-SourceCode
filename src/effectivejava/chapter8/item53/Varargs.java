package effectivejava.chapter8.item53;

// Примеры использования методов с переменным количеством аргументов
public class Varargs {
    // Простое использование метода
    // с переменным количеством аргументов
    static int sum(int... args) {
        int sum = 0;

        for (int arg : args)
            sum += arg;

        return sum;
    }

//    // НЕВЕРНЫЙ способ использования метода с переменным
//    // количеством аргументов для передачи одного
//    // или большего количества аргументво
//    static int min(int... args) {
//        if (args.length == 0)
//            throw new IllegalArgumentException("Слишком мало аргументов");
//
//        int min = args[0];
//
//        for (int i = 1; i < args.length; i++) {
//            if (args[i] < min)
//                min = args[i];
//        }
//        return min;
//    }

    // Правильный способ использования метода с переменным
    // количеством аргументов для передачи одного
    // или большего количества аргументов
    static int min(int firstArgs, int... remainingArgs) {
        int min = firstArgs;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
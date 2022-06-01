package effectivejava.chapter6.item39.annotationwitharrayparameter;

import java.util.ArrayList;
import java.util.List;

// Программа, содержащая аннотацию с параметром
public class Sample3 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Тест должен быть пройден
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Тест не должен быть пройден (неверное исключение)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() { // Тест не должен быть пройден (нет исключения)
    }

    // Код, содержащий аннотацию с параметром - массовом
    @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        // Спецификация разрешает этому методу генерировать
        // IndexOutOfBoundsException или NullPointerException
        list.addAll(5, null);
    }
}
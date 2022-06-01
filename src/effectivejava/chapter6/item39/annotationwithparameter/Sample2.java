package effectivejava.chapter6.item39.annotationwithparameter;

// Программа, содержащая аннотацию с параметром
public class Sample2 {

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
    public static void m3(){ // Тест не должен быть пройден (нет исключения)
    }
}
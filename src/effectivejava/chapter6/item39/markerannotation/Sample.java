package effectivejava.chapter6.item39.markerannotation;

// Программа, содержащая аннотации-маркеры
public class Sample {

    @Test
    public static void m1() { // Тест должен быть пройден
    }

    public static void m2() {
    }

    @Test
    public static void m3() { // Тест не должен быть пройден
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public void m5() { // НЕВЕРНОЕ ИСПОЛЬЗОВАНИЕ: нестатический метод
    }

    public static void m6() {
    }

    @Test
    public static void m7() { // Тест не должен быть пройден
        throw new RuntimeException("Crash");
    }

    public static void m8(){
    }
}
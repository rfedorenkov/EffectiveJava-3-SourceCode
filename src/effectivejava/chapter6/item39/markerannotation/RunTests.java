package effectivejava.chapter6.item39.markerannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Программа для обработки аннотаций-маркеров
// arg[0] = effectivejava.chapter6.item39.markerannotation.Sample
public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Пройдено: %d, Сбоев: %d%n", passed, tests - passed);
    }
}
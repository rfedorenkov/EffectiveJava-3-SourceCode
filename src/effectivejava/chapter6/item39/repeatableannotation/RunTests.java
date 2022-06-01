package effectivejava.chapter6.item39.repeatableannotation;

import effectivejava.chapter6.item39.markerannotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Программа для обработки аннотаций-маркеров и аннотаций с параметром
// arg[0] = effectivejava.chapter6.item39.repeatableannotation.Sample4
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

            if (m.isAnnotationPresent(ExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;

                try {
                    m.invoke(null);
                    System.out.printf("Сбой теста %s: нет исключения%n", m);
                } catch (Throwable wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    int oldPassed = passed;
                    ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
                    for (ExceptionTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed)
                        System.out.printf("Сбой теста %s: %s, %n", m, exc);
                }
            }
        }
        System.out.printf("Пройдено: %d, Сбоев: %d%n", passed, tests - passed);
    }
}
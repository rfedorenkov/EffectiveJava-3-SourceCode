package effectivejava.chapter6.item39.markerannotation;

// Объявление типа аннотации-маркера
import java.lang.annotation.*;

/**
 * Указывает, что аннотированный метод является тестовым.
 * Используется только для статических методов без параметров.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
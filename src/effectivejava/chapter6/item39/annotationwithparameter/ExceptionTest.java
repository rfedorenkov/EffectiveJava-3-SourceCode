package effectivejava.chapter6.item39.annotationwithparameter;

// Тип аннотации с параметром

import java.lang.annotation.*;

/**
 * Указывает, что аннотированный метод является
 * тестирующим методом, который для успешного завершения
 * должен генерировать указанное исключение
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}

package effectivejava.chapter6.item39.repeatableannotation;

// Аннотация контейнера для повторяемой аннотации ExceptionTest

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestContainer {
    ExceptionTest[] value();
}

package effectivejava.chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

// Демонстрация рефлективного инстанцирования
public class ReflectiveInstantiation {
    // Рефлективное инстанцирование с доступом через интерфейс
    public static void main(String[] args) {
        // Перевод имени класса в объект Class
        Class<? extends Set<String>> cl = null;

        try {
            cl = (Class<? extends Set<String>>)  // Непроверяемое приведение!
                    Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("Класс не найден");
        }

        // Получение конструктора
        Constructor<? extends Set<String>> cons = null;

        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("Нет конструктора без параметров");
        }

        // Инстанцирование множества
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("Конструктор недоступен");
        } catch (InstantiationException e) {
            fatalError("Класс не инстанцируем.");
        } catch (InvocationTargetException e) {
            fatalError("Конструктор генерирует " + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Класс не реализует Set");
        }

        // Работа с множеством
        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}
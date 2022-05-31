package effectivejava.chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Общий стек с массовыми методами, использующими подстановочные знаки
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // Массив elements содержит только экземпляры E из push(E).
    // Этого достаточно для гарантии безопасности типов, но тип
    // времени выполнения массива не может быть E[]; он всегда
    // должен быть Object[]!
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        E result = elements[--size];
        elements[size] = null; // Устранение устаревшей ссылки
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//    // Метод pushAll без типа с символами
//    // подстановки - этого недостаточно!
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }

    // Тип с символом подстановки в параметре,
    // служащем в качестве производителя E
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

//    // Метод popAll без применения типов с символами
//    // подстановки - этого не достаточно!
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }

    // Тип с символом подстановки для параметра,
    // который служит потребителем E
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }

    // Небольшая программа с использованием обобщенного Stack
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        System.out.println(objects);
    }
}
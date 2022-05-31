package effectivejava.chapter5.item29.technqiue2;

import effectivejava.chapter5.item29.EmptyStackException;

import java.util.Arrays;

// Коллекция на основе Object - основной кандидат на обобщение
public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Подавление предупреждения о непроверяемой операции
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        // push требует, чтобы элементы были типа E,
        // поэтому приведение корректно
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
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

    // Небольшая программа с использованием обобщенного Stack
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (String arg : args)
            stack.push(arg);

        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}

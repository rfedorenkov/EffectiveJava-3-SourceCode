package effectivejava.chapter5.item29.technqiue1;

import effectivejava.chapter5.item29.EmptyStackException;

import java.util.Arrays;

// Общий стек с использованием E[]
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

    // Небольшая программа с использованием обобщенного Stack
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (String arg : args)
            stack.push(arg);

        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
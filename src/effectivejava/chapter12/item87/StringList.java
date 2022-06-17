package effectivejava.chapter12.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// StringList с правильной пользовательской сериализацией
public class StringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;

    // No Longer Serializable
    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // Добавление указанной строки в список
    public final void add(String s) { }

    /**
     * Сериализация этого экземпляра {@code StringList}
     *
     * @serialData Размер списка (количество строк, которые он
     * содержит) ({@code int}), а после него - все элементы
     * списка (каждый {@code String}) в правильном порядке.
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Запись элементов в правильном порядке.
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Чтение всех элементов и вставка их в список
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }

    // Остальная часть кода опущена
}
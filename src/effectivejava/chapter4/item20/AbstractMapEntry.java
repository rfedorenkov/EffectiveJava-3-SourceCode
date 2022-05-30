package effectivejava.chapter4.item20;

import java.util.Map;
import java.util.Objects;

// Класс скелетной реализации
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

    // Записи в изменяемом отображении должны перекрывать этот метод
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Реализует общий контракт Map.Entry.equals
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Map.Entry))
            return false;

        Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
        return Objects.equals(e.getKey(), getKey())
                && Objects.equals(e.getValue(), getValue());
    }

    // Реализует общий контракт Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
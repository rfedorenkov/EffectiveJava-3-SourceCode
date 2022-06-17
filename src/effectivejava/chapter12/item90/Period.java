package effectivejava.chapter12.item90;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

// Прокси сериализации для класса Period
// Неизменяемый класс, использующий защитное копирование
public final class Period implements Serializable {
    private final Date start;
    private final Date end;

    /**
     * @param start - начало промежутка времени
     * @param end   - конец промежутка времени;
     *              не должен предшествовать start
     * @throws IllegalArgumentException если start после end
     * @throws NullPointerException     если start или end равен null
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(this.start + " после " + this.end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    // Прокси сериализации для класса Period
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        private static final long serialVersionUID = 3035550805615113506L; // Любое число
    }

    // Метод writeReplace для шаблона прокси сериализации
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // Метод readObject для шаблона прокси сериализации
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Требуется прокси");
    }
}

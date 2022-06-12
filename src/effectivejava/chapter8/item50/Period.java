package effectivejava.chapter8.item50;

import java.util.Date;

// Некорректный "неизменяемый" класс для промежутка времени
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start - начало промежутка времени
     * @param end - конец промежутка времени;
     *            не должен предшествовать start
     * @throws IllegalArgumentException если start после end
     * @throws NullPointerException если start или end равен null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " после " + end);
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

//    // Исправленный конструктор - с защитным копированием параметров
//    public Period(Date start, Date end) {
//        this.start = new Date(start.getTime());
//        this.end = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(this.start + " после " + this.end);
//    }
//
//    // Исправленные методы доступа - делайте копии внутренних полей
//    public Date start() {
//        return new Date(start.getTime());
//    }
//
//    public Date end() {
//        return new Date(end.getTime());
//    }

    @Override
    public String toString() {
        return start + " - " + end;
    }
}
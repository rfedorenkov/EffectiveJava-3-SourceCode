package effectivejava.chapter8.item56;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Примеры комментариев к документации
public class DocExamples<E> {
    // Комментарий к методу

    /**
     * Возвращает элемент в указанной позиции этого списка.
     * <p>Этот метод <i>не</i> гарантирует работу за константное время.
     * В некоторых реализациях он может выполняться за время,
     * пропорциональное позиции элемента.
     *
     * @param index Индекс возвращаемого элемента; должен быть
     *              неотрицательным и меньше размера списка
     * @return Элемент в указанной позиции списка
     * @throws IndexOutOfBoundsException если индекс
     *         выходит за пределы диапазона
     *         ({@code index < 0 || index >= this.size()})
     */
    E get(int index) {
        return null;
    }

    /**
     * Возвращает true, если эта коллекция пуста.
     *
     * @implSpec
     * Эта реализация возвращает {@code this.size() == 0}.
     *
     * @return true если коллекция пуста
     */
    public boolean isEmpty() {
        return false;
    }

    // Использование тега @literal для включения метасимволов HTML и javadoc в комментарии javadoc.
    /**
     * Геометрический ряд сходится, если {@literal |r| < 1}
     */
    public void fragment() {
    }

    // Управление сводным описанием при наличии точки в первом «предложении» комментария к документу.
    /**
     * Подозреваемый, например полковник Mustard или {@literal Mrs. Peacock}.
     */
    public enum FixedSuspect {
        MISS_SCARLETT, PROFESSOR_PLUM, MRS_PEACOCK, MR_GREEN, COLONEL_MUSTARD, MRS_WHITE
    }

    // Создание записи индекса javadoc в Java 9 и более поздних версиях.
    /**
     * Этот метод скомпилирован согласно стандарту {@index IEEE 754}.
     */
    public void fragment2() {
    }

    /**
     * Объект, отображающий ключи на значения. Отображения
     * не может содержать дублирующиеся ключи; каждый ключ
     * отображается не более чем на одно значение.
     *
     * @param <K> тип ключей этого отображения
     * @param <V> тип значений этого отображения
     */
    public interface Map<K, V> {

    }

    // Документирование констант перечисления
    public enum OrchestraSection {
        /** Деревянные духовые инструменты - флейта, кларнет, гобой. */
        WOODWIND,
        /** Медные духовые инструменты - валторна, труба. */
        BRASS,
        /** Ударные инструменты - литавры, тарелки. */
        PERCUSSION,
        /** Струнные инструменты - скрипка, виолончель. */
        STRING;
    }

    // Документирование типа аннотации
    /**
     * Указывает, что аннотированный метод является
     * тестовым методом, который должен генерировать
     * требуемое исключения для успешного завершения.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExceptionTest {
        /**
         * Исключение, которое аннотированный тестовый метод
         * должен генерировать для успешного завершения. (Тест
         * может генерировать любой подтип типа, описываемого
         * этим объектом класса.)
         */
        Class <? extends Throwable> value();
    }

}
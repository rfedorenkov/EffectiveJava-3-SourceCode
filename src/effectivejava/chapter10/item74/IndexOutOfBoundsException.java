package effectivejava.chapter10.item74;

public class IndexOutOfBoundsException extends RuntimeException {
    private final int lowerBound;
    private final int upperBound;
    private final int index;

    /**
     * Constucts an IndexOutOfBoundsException.
     *
     * @param lowerBound - наименьший разрешенный индекс
     * @param upperBound - наибольший разрешенный индекс
     * @param index      - фактическое значение индекса
     */
    public IndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
        super(String.format(
                "Lower bound: %d, Upper bound: %d, Index: %d",
                lowerBound, upperBound, index));

        // Сохранение информации о сбое для программного доступа
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }
}
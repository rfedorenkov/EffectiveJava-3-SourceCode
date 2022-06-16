package effectivejava.chapter11.item79;

@FunctionalInterface
public interface SetObserver<E> {
    // Вызывается при добавлении элемента к множеству
    void added(ObservableSet<E> set, E element);
}
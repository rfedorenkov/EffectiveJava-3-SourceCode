package effectivejava.chapter4.item19;

import java.time.Instant;

// Демонстрация того, что может пойти не так, когда вы переопределяете метод, вызванный из конструктора
public final class Sub extends Super {
    // Пустое final-поле, устанавливаемое конструктором
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // Перекрывающий метод вызывается конструктором суперкласса
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
package effectivejava.chapter11.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

// Простой каркас для измерения времени параллельного выполнения
public class ConcurrentTimer {
    private ConcurrentTimer() {} // Нереализуемый

    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Сообщаем таймеру о готовности

                try {
                    start.await(); // Ждем готовности остальных
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Сообщаем таймеру о завершении работы
                }
            });
        }

        ready.await(); // Ждем готовности всех рабочих потоков
        long startNanos = System.nanoTime();
        start.countDown(); // Запускаем их!
        done.await(); // Ждем завершения всех рабочих потоков
        return System.nanoTime() - startNanos;
    }
}
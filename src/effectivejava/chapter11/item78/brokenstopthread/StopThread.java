package effectivejava.chapter11.item78.brokenstopthread;

import java.util.concurrent.TimeUnit;

// Неверно! Как вы думаете, сколько времени
// будет работать эта программа?
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
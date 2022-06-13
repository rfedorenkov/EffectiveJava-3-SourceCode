package effectivejava.chapter9.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Вывод содержимого URL с использованием transferTo из Java 9
public class Curl {
    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(args[0]).openStream()) {
            in.transferTo(System.out);
        }
    }
}
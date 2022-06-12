package effectivejava.chapter8.item52;

// Классификация с использованием переопределения метода
public class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}
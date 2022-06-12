package effectivejava.chapter8.item52;

// Классификация с использованием переопределения метода
public class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}
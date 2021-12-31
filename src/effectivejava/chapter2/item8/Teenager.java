package effectivejava.chapter2.item8;

public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");

        // Раскомментируйте следующую строку и повторите попытку, но учтите, что вы НЕ ДОЛЖНЫ зависеть от этого поведения
        // System.gc();
    }
}

package effectivejava.chapter4.item19;

// Класс, конструктор которого вызывает переопределяемый метод. НИКОГДА ЭТОГО НЕ ДЕЛАЙТЕ!
public class Super {
    // Ошибка - конструктор вызывает метод,
    // который может быть переопределен.
    public Super() {
        overrideMe();
    }
    //Класс, конструктор которого вызывает переопределяемый метод. НИКОГДА ЭТОГО НЕ ДЕЛАЙТЕ!

    public void overrideMe() {

    }
}
package effectivejava.chapter2.item4;

// Неинстанцируемый служебный класс
public class UtilityClass {

    // Подавление создания конструктора по умолчанию
    // для достижения неинстанцируемости
    private UtilityClass() {
        throw new AssertionError();
    }
}

//// Noninstantiable utility class (Page 19)
//public class UtilityClass {
//    // Suppress default constructor for noninstantiability
//    private UtilityClass() {
//        throw new AssertionError();
//    }
//
//    // Remainder omitted
//}
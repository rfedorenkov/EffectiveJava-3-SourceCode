package effectivejava.chapter11.item83;


public class Initialization {

    // Обычная инициализация поля экземпляра
    private final FieldType field1 = computeFieldValue();

    // Отложенная инициализация поля экземпляра -
    // синхронизированный метод доступа
    private FieldType field2;
    private synchronized FieldType getField2() {
        if (field2 == null)
            field2 = computeFieldValue();

        return field2;
    }

    // Идиома класса отложенной инициализации для статических полей
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    private static FieldType getField() {
        return FieldHolder.field;
    }

    // Идиома двойной проверки для
    // отложенной инициализации полей экземпляров
    private volatile FieldType field4;

    private FieldType getField4() {
        FieldType result = field4;

        if (result == null) { // Первая проверка (без блокировки)
            synchronized (this) {
                if (field4 == null) // Вторая проверка (с блокировкой)
                    field4 = result = computeFieldValue();
            }
        }

        return result;
    }

    // Идиома однократной проверки - может
    // приводить к повторной инициализации!
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;

        if (result == null)
            field5 = result = computeFieldValue();

        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}


//
//    // Single-check idiom - can cause repeated initialization! - Page 334
//    private volatile FieldType field5;
//
//    private FieldType getField5() {
//        FieldType result = field5;
//        if (result == null)
//            field5 = result = computeFieldValue();
//        return result;
//    }
//

//}
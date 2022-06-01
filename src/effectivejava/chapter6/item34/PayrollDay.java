package effectivejava.chapter6.item34;

// Схема применения стратегии-перечисления
enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;


    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY); // По умолчанию
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    // Тип стратегии-перечисления
    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        for (PayrollDay day : values())
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }
}

//// Перечисление с использованием switch
//// для совместного использования кода - спорно
//enum PayrollDay {
//    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
//    SATURDAY, SUNDAY;
//
//    private static final int MINS_PER_SHIFT = 8 * 60;
//
//    int pay(int minutesWorked, int payRate) {
//        int basePay = minutesWorked * payRate;
//        int overtimePay;
//        switch (this) {
//            case SATURDAY:
//            case SUNDAY: // Выходной день
//                overtimePay = basePay / 2;
//                break;
//            default: // Будний день
//                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
//        }
//        return basePay + overtimePay;
//    }
//
//        public static void main(String[] args) {
//        for (PayrollDay day : values())
//            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
//    }
//}
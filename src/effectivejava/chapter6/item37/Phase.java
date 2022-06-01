package effectivejava.chapter6.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

// Использование вложенного EnumMap
// для связи данных с парами перечислений
public enum Phase {
    SOLID, LIQUID, GAS,
    // Добавление нового агрегатного состояния
    PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),

        // Добавление нового агрегатного состояния
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Инициализация отображения фазовых переходов
        private static final Map<Phase, Map<Phase, Transition>>
                m = Stream.of(values())
                .collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
                        toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        for (Phase src : Phase.values()) {
            for (Phase dst : Phase.values()) {
                Transition transition = Transition.from(src, dst);
                if (transition != null) {
                    System.out.printf("%s to %s : %s %n", src, dst, transition);
                }
            }
        }
    }
}


//// Использование ordinal() для индексирования
//// массива массивов - НЕ ДЕЛАЙТЕ ТАК!
//public enum Phase {
//    SOLID, LIQUID, GAD;
//
//    public enum Transition {
//        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
//
//        // Строки индексированы порядковыми значениями from,
//        // столбцы - порядковыми значениями to
//        private static final Transition[][] TRANSITIONS = {
//                {null, MELT, SUBLIME},
//                {FREEZE, null, BOIL},
//                {DEPOSIT, CONDENSE, null}
//        };
//
//        // Возвращает фазовый переход из одного
//        // агрегатного состояния в другое
//        public static Transition from(Phase from, Phase to) {
//            return TRANSITIONS[from.ordinal()][to.ordinal()];
//
//        }
//    }
//}
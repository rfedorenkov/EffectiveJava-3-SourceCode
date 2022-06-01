package effectivejava.chapter6.item34;

// Применение switch с перечислением
// для имитации отсутствующего метода
public class Inverse {
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS:
                return Operation.MINUS;
            case MINUS:
                return Operation.PLUS;
            case TIMES:
                return Operation.DIVIDE;
            case DIVIDE:
                return Operation.TIMES;
            default:
                throw new AssertionError("Неизвестная операция: " + op);
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()) {
            Operation invOp = inverse(op);
            System.out.printf("%f %s %f %s %f = %f%n",
                    x, op, y, invOp, y, invOp.apply(op.apply(x, y), y));
        }
    }
}

/* Output:
args[0] = 10
args[1] = 2
10.000000 + 2.000000 - 2.000000 = 10.000000
10.000000 - 2.000000 + 2.000000 = 10.000000
10.000000 * 2.000000 / 2.000000 = 10.000000
10.000000 / 2.000000 * 2.000000 = 10.000000
 */
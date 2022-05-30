package effectivejava.chapter3.item11;

import java.util.HashMap;
import java.util.Map;

// Класс с типичным методом equals и hashCode
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof PhoneNumber))
            return false;

        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    // Наихудшая допустимая реализация
    // hashCode - никогда так не делайте!
//    @Override
//    public int hashCode() {
//        return 42;
//    }

    // Типичный метод hashCode
//    @Override
//    public int hashCode() {
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

    // Однострочный метод hashCode с посредственной производительностью
//    @Override
//    public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    // Метод hashCode с отложенной инициализацией
    // и кешированием хеш-кода
//    private int hashCode; // Автоматически инициализируется значением 0
//
//    @Override
//    public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result * Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}


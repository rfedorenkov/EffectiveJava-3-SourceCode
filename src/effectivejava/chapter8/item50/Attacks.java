package effectivejava.chapter8.item50;

import java.util.Date;

// Две атаки на внутренности "неизменяемого" периода
public class Attacks {
    public static void main(String[] args) {
        // Изменение внутренних данных экземпляра Period
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78); // Изменение внутреннего состояния p!
        System.out.println(p);

        // Вторая атака внутреннего содержимого экземпляра Period
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        p.end().setYear(78); // Изменение внутреннего состояния p!
        System.out.println(p);
    }
}
package effectivejava.chapter8.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Что печатает эта программа?
public class SetList {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i =-3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i); // [-2, 0, 2]
//            list.remove((Integer) i); // или remove(Integer.valueOf(i)) [-3, -2, -1]
        }

        System.out.println(set + " " + list);
    }
}
package effectivejava.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// Та же ошибка, но с другим симптомом!
public class DiceRolls {
    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void main(String[] args) {
        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (Iterator<Face> i = faces.iterator(); i.hasNext();)
            for (Iterator<Face> j = faces.iterator(); j.hasNext();)
                System.out.println(i.next() + " " + j.next());

        System.out.println("***************************");

        for (Face f1 : faces) {
            for (Face f2 : faces) {
                System.out.println(f1 + " " + f2);
            }
        }

    }
}
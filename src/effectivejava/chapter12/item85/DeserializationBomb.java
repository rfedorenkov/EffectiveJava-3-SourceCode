package effectivejava.chapter12.item85;

import java.util.HashSet;
import java.util.Set;

import static effectivejava.chapter12.Util.deserialize;
import static effectivejava.chapter12.Util.serialize;

// Бомба десериализации - десериализация такого потока длится вечно
public class DeserializationBomb {

    public static void main(String[] args) {
        System.out.println(bomb().length);
        deserialize(bomb());
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // Делаем t1 неравным t2
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }

        return serialize(root);
    }
}
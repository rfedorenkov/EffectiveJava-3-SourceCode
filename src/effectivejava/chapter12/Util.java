package effectivejava.chapter12;

import java.io.*;

public class Util {
    public static byte[] serialize(Object o) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(baos).writeObject(o);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return baos.toByteArray();
    }

    public static Object deserialize(byte[] bytes) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
package effectivejava.chapter12.item89.enumsingleton;

import java.util.Arrays;

// Синглтон-перечисление - предпочтительный подход
public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
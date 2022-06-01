package effectivejava.chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// EnumSet - современная замена битовых полей
public class Text {

    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    // Можно передать любой Set, но EnumSet наиболее понятен
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    // Простой пример
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

//// Константы перечисления в виде битовых полей - УСТАРЕЛО!
//public class Text {
//    public static final int STYLE_BOLD = 1 << 0; // 1
//    public static final int STYLE_ITALIC = 1 << 1; // 2
//    public static final int STYLE_UNDERLINE = 1 << 2; // 4
//    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8
//
//    // Параметр представляет собой побитовое ИЛИ из нуля
//    // или большего количества констант STYLE_
//    // text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
//    public void applyStyles(int styles) { ... }
//}
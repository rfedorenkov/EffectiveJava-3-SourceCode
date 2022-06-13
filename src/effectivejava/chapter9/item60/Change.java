package effectivejava.chapter9.item60;

public class Change {

    // Неверно - применение типа с плавающей
    // точкой для денежный вычислений!
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;

        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }

        System.out.println("Куплено " + itemsBought + " штук.");
        System.out.println("Сдача: $" + funds);
    }
}
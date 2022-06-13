package effectivejava.chapter9.item60;

public class IntChange {
    public static void main(String[] args) {
        int itemBought = 0;
        int funds = 100;

        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemBought++;
        }

        System.out.println("Куплено " + itemBought + " штук.");
        System.out.println("Сдача: " + funds + " центов.");
    }
}
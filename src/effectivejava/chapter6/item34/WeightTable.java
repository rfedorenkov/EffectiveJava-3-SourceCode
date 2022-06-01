package effectivejava.chapter6.item34;

// Берет земной вес и выводит таблицу весов этого объекта на всех планетах
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Вес на планете %s равен %f%n", p, p.surfaceWeight(mass));
    }
}

/* Output:
args[0] = 185
Вес на планете MERCURY равен 69.912739
Вес на планете VENUS равен 167.434436
Вес на планете EARTH равен 185.000000
Вес на планете MARS равен 70.226739
Вес на планете JUPITER равен 467.990696
Вес на планете SATURN равен 197.120111
Вес на планете URANUS равен 167.398264
Вес на планете NEPTUNE равен 210.208751
 */
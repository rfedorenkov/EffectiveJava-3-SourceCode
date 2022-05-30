package effectivejava.chapter4.item16;

// Инкапсуляция данных с помощью методов доступа и установки
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

// Вырожденные классы наподобие данного не должны быть открытыми!
class Point2 {
    public double x;
    public double y;
}
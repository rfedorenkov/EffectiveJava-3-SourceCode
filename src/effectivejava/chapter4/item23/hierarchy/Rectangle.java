package effectivejava.chapter4.item23.hierarchy;

// Иерархия классов взамен класса с дескриптором
class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
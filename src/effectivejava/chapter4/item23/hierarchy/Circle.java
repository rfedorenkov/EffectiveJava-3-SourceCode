package effectivejava.chapter4.item23.hierarchy;

// Иерархия классов взамен класса с дескриптором
class Circle extends Figure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
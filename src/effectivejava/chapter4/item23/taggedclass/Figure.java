package effectivejava.chapter4.item23.taggedclass;

// Класс с дескриптором: значительно уступает иерархии классов!
class Figure {
    enum Shape { RECTANGLE, CIRCLE };

    // Поля дескриптора - форма данной фигуры
    final Shape shape;

    // Эти поля используются в RECTANGLE
    double length;
    double width;

    // Это поле используется в CIRCLE
    double radius;

    // Конструктор окружности
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Конструктор прямоугольника
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
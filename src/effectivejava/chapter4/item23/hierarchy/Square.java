package effectivejava.chapter4.item23.hierarchy;

// Иерархия классов взамен класса с дескриптором
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}


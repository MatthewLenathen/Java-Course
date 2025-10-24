public class Square extends Shape {
    private final double side;

    public Square(double side, String colour) {
        this.side = side;
        this.colour = colour;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    double getPerimeter() {
        return 4 * side;
    }
}

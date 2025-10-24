public class Triangle extends Shape{
    // Assuming equilateral triangle
    private final double side;

    Triangle(double side, String colour){
        this.side = side;
        this.colour = colour;
    }

    @Override
    double getArea() {
        return (Math.sqrt(3) / 4.0) * side * side;
    }

    @Override
    double getPerimeter() {
        return 3 * side;
    }
}

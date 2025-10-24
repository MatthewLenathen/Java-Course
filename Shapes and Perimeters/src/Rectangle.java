public class Rectangle extends Shape{
    private final double length;
    private final double height;

    Rectangle(double length, double height, String colour){
        this.length = length;
        this.height = height;
        this.colour = colour;
    }

    @Override
    double getArea() {
        return length * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + height);
    }
}

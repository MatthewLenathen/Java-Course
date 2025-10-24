import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(3,"Yellow");
        Shape triangle = new Triangle(5.4, "Orange");
        Shape rectangle = new Rectangle(3.5,2.0,"Green");

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(square);
        shapes.add(triangle);
        shapes.add(rectangle);

        for(var shape : shapes){
            System.out.println(shape.getClass().getSimpleName());
            shape.printStats();
            System.out.println("The area is: " + shape.getArea());
            System.out.println("The perimeter is: " + shape.getPerimeter());
            System.out.println();
        }
    }
}
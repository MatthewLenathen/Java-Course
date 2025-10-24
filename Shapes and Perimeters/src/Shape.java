public abstract class Shape {
    protected String colour;

    abstract double getArea();
    abstract double getPerimeter();

    void printStats(){
        System.out.println("This shape be: "+ colour);
    }
}

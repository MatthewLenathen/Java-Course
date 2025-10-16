import java.util.Scanner;

public class WindowMaster {
    public static final float GLASS_COST = 3.5F;
    public static final float TRIM_COST = 2.25F;

    public static void main(String[] args) {
        // declare variables for height and width
        float height;
        float width;

        // declare String variables to hold the user's height and width input
        String stringHeight;
        String stringWidth;

        // declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;

        // declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);

        // get input from the user
        System.out.println("Please enter window height:");
        stringHeight = myScanner.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = myScanner.nextLine();

        // convert strings to ints
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);

        // calculate area of window
        areaOfWindow = height * width;

        // calc perimeter
        perimeterOfWindow = 2 * (height+width);

        // finally, calc cost of window
        cost = (areaOfWindow * GLASS_COST) + (perimeterOfWindow * TRIM_COST);

        // display the results to the user
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost =  " + cost);

    }
}

import java.util.Scanner;

public class App {
    private final Scanner inputScanner = new Scanner(System.in);
    private final SimpleCalculator calc = new SimpleCalculator();

    public void start(){
        while(true) {
            System.out.println("Welcome to calculator!");
            System.out.println("Please select the operation you would like to carry out:");
            System.out.println("1: Addition");
            System.out.println("2: Subtraction");
            System.out.println("3: Multiplication");
            System.out.println("4: Division");
            System.out.println("5: Exit");

            int choice = getChoice();
            if (choice == 5) {
                System.out.println("Thank you for using calculator.");
                break;
            }
            int[] nums = getNumbers();

            double result = handleCalc(choice, nums);
            System.out.println("Result: " + result);
            System.out.println();
        }
        inputScanner.close();
    }

    private int getChoice(){
        while(true){
            int choice = inputScanner.nextInt();
            if(choice < 1 || choice > 5){
                System.out.println("Please enter a valid choice.");
            }else{
                return choice;
            }
        }
    }
    private int[] getNumbers() {
        int[] nums = new int[2];
        System.out.println("Please enter the first number: ");
        nums[0] = inputScanner.nextInt();
        System.out.println("Please enter the second number: ");
        nums[1] = inputScanner.nextInt();

        return nums;
    }

    private double handleCalc(int choice, int[] nums){
        return switch(choice){
            case 1 -> calc.add(nums[0],nums[1]);
            case 2 -> calc.subtract(nums[0],nums[1]);
            case 3 -> calc.multiply(nums[0],nums[1]);
            case 4 -> calc.divide(nums[0],nums[1]);
            default -> 0.0;
        };
    }




}

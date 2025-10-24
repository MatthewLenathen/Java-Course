import java.util.Random;
import java.util.Scanner;

public class Player {
    private Scanner inputReader;
    private Random rng;
    private String name;
    private final boolean isHuman;

    // Computer constructor
    public Player(String name, Random rng) {
        this.name = name;
        this.rng = rng;
        this.isHuman = false;
    }

    public Player(String name, Scanner inputReader){
        this.name = name;
        this.inputReader = inputReader;
        this.isHuman = true;
    }

    public int getChoice(){
        if(isHuman){
            return getUserChoice();
        }else{
            return rng.nextInt(1,4);
        }
    }
    private int getUserChoice(){
        int userChoiceInt = 0;
        String userChoice;
        while (userChoiceInt == 0) {
            System.out.print("Rock paper scissors?: ");
            userChoice = inputReader.nextLine();

            switch (userChoice.toLowerCase()) {
                case "rock" -> userChoiceInt = 1;
                case "paper" -> userChoiceInt = 2;
                case "scissors" -> userChoiceInt = 3;
                default -> System.out.println("Please enter a valid choice");
            }
        }
        return userChoiceInt;
    }
    public static String choiceToString(int choice){
        return switch(choice){
            case 1 -> "rock";
            case 2 -> "paper";
            case 3 -> "scissors";
            default -> "unknown";
        };
    }
}

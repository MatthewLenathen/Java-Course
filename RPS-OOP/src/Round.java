import java.util.Random;
import java.util.Scanner;

public class Round {
    private final Scanner inputReader;
    private final Random rng;
    private String name;

    public Round(Scanner inputReader, Random rng) {
        this.inputReader = inputReader;
        this.rng = rng;
    }

    public int playRound(){
        Player user = new Player("User",inputReader);
        Player computer = new Player("Computer",rng);

        int userChoice = user.getChoice();
        int computerChoice = computer.getChoice();

        String userChoiceString = Player.choiceToString(userChoice);
        String computerChoiceString = Player.choiceToString(computerChoice);

        System.out.println("You picked " + userChoiceString + ", computer picked " + computerChoiceString);

        return decideWinner(userChoice,computerChoice);
    }

    // This function will return an int representing the winner of the game
    // -1 = userWin, 0 = draw, 1 = computer win
    private int decideWinner(int userChoice, int computerChoice){
        // Rock = 1, Paper = 2, Scissors = 3
        // Three main if statements representing user choices

        // User picks rock
        if (userChoice == 1) {
            if (computerChoice == 1) {
                return 0;
            }
            if (computerChoice == 2) {
                return 1;
            }
            if (computerChoice == 3) {
                return -1;
            }
        }

        // User picks paper
        if (userChoice == 2) {
            if (computerChoice == 1) {
                return -1;
            }
            if (computerChoice == 2) {
                return 0;
            }
            if (computerChoice == 3) {
                return 1;
            }
        }

        // User picks scissors
        if (userChoice == 3) {
            if (computerChoice == 1) {
                return 1;
            }
            if (computerChoice == 2) {
                return -1;
            }
            if (computerChoice == 3) {
                return 0;
            }
        }
        return 10; // This should never execute assuming I've handled userInput and rng properly.
    }



}

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random rng = new Random();

        int userWins = 0;
        int draws = 0;
        int computerWins = 0;

        System.out.println("Welcome to rock paper scissors!");

        int gamesToPlay = readNumberOfGames(inputReader);

        // Main game loop
        for (int i = 0; i < gamesToPlay; i++) {
            int roundWinner = playRound(inputReader, rng);

            switch (roundWinner) {
                case -1 -> userWins++;
                case 0 -> draws++;
                case 1 -> computerWins++;
            }
        }

        // Print end of game results
        printResults(userWins, draws, computerWins);
    }

    // Method that acquires input from user and semi-validates it.
    static int readNumberOfGames(Scanner inputReader) {
        System.out.print("How many games would you like to play? (1-10): ");
        int games = inputReader.nextInt();
        inputReader.nextLine(); // consume newline
        if (games < 0 || games > 10) {
            System.out.println("Error, number of games: " + games + " is out of range.");
            System.exit(0);
        }
        return games;
    }

    // Decides a winner based on rng and user input
    static int playRound(Scanner inputReader, Random rng) {
        String userChoice = "";
        int userChoiceInt = 0;

        while (userChoiceInt == 0) {
            System.out.print("Rock paper scissors?: ");
            userChoice = inputReader.nextLine();

            switch (userChoice.toLowerCase()) {
                case "rock" -> userChoiceInt = 1;
                case "paper" -> userChoiceInt = 2;
                case "scissors" -> userChoiceInt = 3;
            }

            if (userChoiceInt == 0) {
                System.out.println("Please enter a valid choice");
            }
        }

        // Get integer from 0 to 3 (use 4 in nextInt because it's exclusive)
        int computerChoice = rng.nextInt(1, 4);

        // This switch is just to display what the computer picked in text
        String computerChoiceString = switch (computerChoice) {
            case 1 -> "rock";
            case 2 -> "paper";
            case 3 -> "scissors";
            default -> "";
        };

        // Return the final winner
        System.out.println("You picked " + userChoice + ", computer picked " + computerChoiceString);
        return decideWinner(userChoiceInt, computerChoice);
    }

    // This function will return an int representing the winner of the game
    // -1 = userWin, 0 = draw, 1 = computer win
    static int decideWinner(int userNum, int computerNum) {
        // Rock = 1, Paper = 2, Scissors = 3
        // Three main if statements representing user choices

        // User picks rock
        if (userNum == 1) {
            if (computerNum == 1) {
                return 0;
            }
            if (computerNum == 2) {
                return 1;
            }
            if (computerNum == 3) {
                return -1;
            }
        }

        // User picks paper
        if (userNum == 2) {
            if (computerNum == 1) {
                return -1;
            }
            if (computerNum == 2) {
                return 0;
            }
            if (computerNum == 3) {
                return 1;
            }
        }

        // User picks scissors
        if (userNum == 3) {
            if (computerNum == 1) {
                return 1;
            }
            if (computerNum == 2) {
                return -1;
            }
            if (computerNum == 3) {
                return 0;
            }
        }
        return 10; // This should never execute assuming I've handled userInput and rng properly.
    }

    // Prints out text based on the game statistics
    static void printResults(int userWins, int draws, int computerWins) {
        System.out.println("The game has finished. The results are as follows:");
        System.out.println();
        System.out.println("User wins: " + userWins);
        System.out.println("Draws: " + draws);
        System.out.println("Computer wins: " + computerWins);
        System.out.println();
        System.out.println("The overall winner is: " + (userWins > computerWins ? "User!" : (userWins < computerWins) ? "Computer :(" : "no one!"));
    }
}
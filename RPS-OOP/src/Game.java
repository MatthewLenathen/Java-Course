import java.util.Random;
import java.util.Scanner;

public class Game {
    // The game will only use one of each of these, save making new ones
    private final Scanner inputReader = new Scanner(System.in);
    private final Random rng = new Random();

    private int userWins;
    private int draws;
    private int computerWins;

    public Game(){
        this.userWins = 0;
        this.draws = 0;
        this.computerWins = 0;
    }

    public void start(){
        System.out.println("Welcome to rock paper scissors!");
        int gamesToPlay = readNumberOfGames(inputReader);

        // Main game loop
        for (int i = 0; i < gamesToPlay; i++) {
            Round round = new Round(inputReader,rng);
            int roundWinner = round.playRound();

            switch (roundWinner) {
                case -1 -> userWins++;
                case 0 -> draws++;
                case 1 -> computerWins++;
            }
        }

        // Print end of game results
        printResults(userWins, draws, computerWins);
    }

    public int readNumberOfGames(Scanner inputReader){
        System.out.print("How many games would you like to play? (1-10): ");
        int games = inputReader.nextInt();
        inputReader.nextLine(); // consume newline
        if (games < 1 || games > 10) {
            System.out.println("Error, number of games: " + games + " is out of range.");
            System.exit(0);
        }
        inputReader.close();

        return games;
    }

    public void printResults(int userWins, int draws, int computerWins){
        System.out.println("The game has finished. The results are as follows:");
        System.out.println();
        System.out.println("User wins: " + userWins);
        System.out.println("Draws: " + draws);
        System.out.println("Computer wins: " + computerWins);
        System.out.println();
        System.out.println("The overall winner is: " + (userWins > computerWins ? "User!" : (userWins < computerWins) ? "Computer :(" : "no one!"));
    }
}

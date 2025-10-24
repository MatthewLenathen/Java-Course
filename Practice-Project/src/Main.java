import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //BarelyControlledChaos.main(new String[]{"test"});
        int num = 10;
        int sum = 1;
        for(int i = 2;i<=num;i++){
            sum*=i;
        }
        System.out.println(sum);
        /*
        Random rng = new Random();
        double chance = 1.0/3000.0;
        for (int i = 0; i < 5000; i++) {
            if(rng.nextDouble()<chance){
                System.out.println("Won on kc: "+i);
                break;
            }
        }
        */
        // Mad libs example
        /*
        System.out.println("Let's play mad libs!");
        Scanner sc = new Scanner(System.in);

        // Get all inputs, assume no input errors
        System.out.print("I need a noun: ");
        String noun = sc.nextLine();

        System.out.print("Now an adjective: ");
        String adjective = sc.nextLine();

        System.out.print("Another noun: ");
        String noun2 = sc.nextLine();

        System.out.print("And a number: ");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.print("Another adjective: ");
        String adjective2 = sc.nextLine();

        System.out.print("A plural noun: ");
        String pluralNoun = sc.nextLine();

        System.out.print("Another one: ");
        String pluralNoun2 = sc.nextLine();

        System.out.print("One more: ");
        String pluralNoun3 = sc.nextLine();

        System.out.print("A verb (infinitive form): ");
        String infVerb = sc.nextLine();

        System.out.print("Same verb (past participle): ");
        String pastPar = sc.nextLine();

        System.out.println("Now lets get mad libs");

        System.out.printf("%s: the %s frontier. These are the voyages of the starship %s. Its %d-year mission: to explore strange %s %s, to seek out %s %s and %s %s, to boldly %s where no one has %s before.",noun,adjective,noun2,num1,adjective2,pluralNoun,adjective2,pluralNoun2,adjective2,pluralNoun3,infVerb,pastPar);
        */
    }
    int calcnum(int a){
        return 1;
    }


}
class BarelyControlledChaos {

    public static void main(String[] args) {
        Random rng = new Random();
        String color = getColour(rng); // call color method here
        String animal = getAnimal(rng); // call animal method again here
        String colorAgain = getColour(rng); // call color method again here
        int weight = getRandomNumber(rng,5,200); // call number method,
        // with a range between 5 - 200
        int distance = getRandomNumber(rng,10,20); // call number method,
        // with a range between 10 - 20
        int number = getRandomNumber(rng,10000,20000); // call number method,
        // with a range between 10000 - 20000
        int time = getRandomNumber(rng,2,6); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    // ??? Method 1 ???
    static String getColour(Random rng){
        return switch (rng.nextInt(5) + 1) {
            case 1 -> "Red";
            case 2 -> "Green";
            case 3 -> "Blue";
            case 4 -> "Orange";
            case 5 -> "Black";
            default -> "Silver";
        };
    }
    // ??? Method 2 ???
    static String getAnimal(Random rng){
        return switch(rng.nextInt(5)+1){
            case 1 -> "Horse";
            case 2 -> "Pig";
            case 3 -> "Cat";
            case 4 -> "Dog";
            case 5 -> "Rabbit";
            default -> "Mammoth";
        };
    }
    //Write another method that returns a random integer chosen from a range (min/max) that can be either of the two numbers or anything between.
    // ??? Method 3 ???
    static int getRandomNumber(Random rng,int min, int max){
        return rng.nextInt(min,max+1);
    }
}
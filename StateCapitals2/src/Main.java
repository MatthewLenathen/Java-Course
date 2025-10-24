import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String,String> stateCapitalMap = new HashMap<>();
        readFromFile(new File("state_capitals.txt"),stateCapitalMap);
        Random rng = new Random();
        String[] randomCombo = new String[2];

        int rngNum = rng.nextInt(0,50);
        int count = 0;


        System.out.printf("%d STATES & CAPITALS ARE LOADED\n",stateCapitalMap.size());
        System.out.println("===================================");
        System.out.println("HERE ARE THE STATES: ");
        for(var s : stateCapitalMap.keySet()){
            System.out.printf("%s, ",s);
            if(rngNum == count){
                randomCombo[0] = s;
                randomCombo[1] = stateCapitalMap.get(s);
            }
            count++;
        }
        System.out.println();
        System.out.println("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF "+randomCombo[0]+"?");

        Scanner sc = new Scanner(System.in);
        System.out.println(randomCombo[1].toLowerCase().equals(sc.nextLine()) ? "NICE WORK!" : "WRONG!");
    }

    public static void readFromFile(File inputFile, Map<String,String> stateCapitalMap) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(inputFile)));
        while (sc.hasNextLine()){
            String currentLine = sc.nextLine();
            String[] dataFromLine = currentLine.split("::");
            stateCapitalMap.put(dataFromLine[0],dataFromLine[1]);
        }
    }
}
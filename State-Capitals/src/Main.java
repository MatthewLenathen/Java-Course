import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,String> stateCapitals = new HashMap<>();
        List<String> test = new ArrayList<>();

        Map<String, Integer> dogKennel = new HashMap<>();
        //dogKennel.put(new Dog("Fido"), new DogHouse("Red"));
        //dogKennel.put(new Dog("Fifi"), new DogHouse("Blue Striped"));
        //dogKennel.put(new Dog("Fred"), new DogHouse("Yellow-Roofed"));
        //dogKennel.put(new Dog("Foxx"), new DogHouse("Black & White"));
        Set<String> allKeys = dogKennel.keySet();
        Collection<String> allKeys1 = dogKennel.keySet();

        stateCapitals.put("Alabama","Montgomery");
        stateCapitals.put("United Kingdom","London");
        stateCapitals.put("Scotland","Edinburgh");
        stateCapitals.put("France","Paris");
        stateCapitals.put("Germany","Berlin");

        printStates(stateCapitals);
        printCapitals(stateCapitals);
        printStateCapitalPairs(stateCapitals);
    }

    static void printStates(Map<String, String> stateCapitals){
        System.out.println("States:\n=======");
        for(String k : stateCapitals.keySet()){
            System.out.println(k);
        }
        System.out.println("===========");
    }

    static void printCapitals(Map<String, String> stateCapitals){
        System.out.println("Capitals:\n=======");
        for(String k : stateCapitals.values()){
            System.out.println(k);
        }
        System.out.println("============");
    }

    static void printStateCapitalPairs(Map<String, String> stateCapitals){
        System.out.println("State/capital pairs:\n=======");
        for(String k : stateCapitals.keySet()){
            System.out.println(k+" "+stateCapitals.get(k));
        }
    }
}
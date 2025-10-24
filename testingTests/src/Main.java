public class Main {
    public static void main(String[] args) {
        happyLlamas(true,30);
    }
    public static boolean happyLlamas(boolean nasa, int trampolines){
        return nasa ? (trampolines >= 24) : (trampolines >= 24 && (trampolines <= 42));
    }
}
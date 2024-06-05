import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = "";
        ClassicWordle.addWord();
        ClassicWordle.setWord();
        while (!option.equals("NO")) {
            ClassicWordle.userGuess();
            System.out.println("Try again? (Type \"NO\" to quit. Type anything else to continue.)");
            option = scan.nextLine();
            if (option.equals("NO")) {
                System.out.println("Bye Bye!");
            } else {
                System.out.println("Retrying...");
                System.out.println("Last word was: " + ClassicWordle.getWord());
                ClassicWordle.setWord();
            }
        }
    }
}

import java.util.Scanner;

public class Conversation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        try {
            System.out.println("Greetings! How are you doing?");
            String response1 = scanner.nextLine();
            System.out.println(response1);
            System.out.println("Oh, how interesting. Tell me more!");
            String response2 = scanner.nextLine();
            System.out.println(response2);
            System.out.println("Thanks for sharing!");
        } finally {
            scanner.close();
        }

    }
}

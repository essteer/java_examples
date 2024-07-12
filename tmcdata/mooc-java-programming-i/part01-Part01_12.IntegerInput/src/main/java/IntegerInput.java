
import java.util.Scanner;

public class IntegerInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        try {
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());
            System.out.println("You gave the number " + number);
        } finally {
            scanner.close();
        }

    }
}

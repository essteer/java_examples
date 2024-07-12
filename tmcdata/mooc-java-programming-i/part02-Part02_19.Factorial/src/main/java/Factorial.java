
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Give a number: ");
            int n = Integer.valueOf(scanner.nextLine());

            int result = 1;

            for (int i=1; i<=n; i++) {
                
                result *= i;
            }

            System.out.println("Factorial: " + result);

        } finally {
            scanner.close();
        }

    }
}

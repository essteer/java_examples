
import java.util.Scanner;

public class SumOfASequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Last number?");
            int n = Integer.valueOf(scanner.nextLine());

            int sum = 0;

            for (int i=1; i<=n; i++) {

                sum += i;

            }

            System.out.println("The sum is " + sum);



        } finally {
            scanner.close();
        }

    }
}

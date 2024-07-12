
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("First number?");
            int m = Integer.valueOf(scanner.nextLine());
            System.out.println("Last number?");
            int n = Integer.valueOf(scanner.nextLine());
            
            int sum = 0;

            for (int i=m; i<=n; i++) {

                sum += i;

            }

            System.out.println("The sum is " + sum);



        } finally {
            scanner.close();
        }

    }
}

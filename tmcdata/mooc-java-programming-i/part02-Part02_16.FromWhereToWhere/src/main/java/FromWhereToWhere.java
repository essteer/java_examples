
import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        try {
            System.out.println("Where to?");
            int upper = Integer.valueOf(scanner.nextLine());

            System.out.println("Where from?");
            int lower = Integer.valueOf(scanner.nextLine());

            for (int i=lower; i<=upper; i++) {
                System.out.println(i);
            }

        } finally {
            scanner.close();
        }
    }
}

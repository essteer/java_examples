
import java.util.Scanner;

public class CountingToHundred {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = Integer.valueOf(scanner.nextLine());

            for (int i=userNum; i<=100; i++) {
                System.out.println(i);
            }

        } finally {
            scanner.close();
        }

    }
}

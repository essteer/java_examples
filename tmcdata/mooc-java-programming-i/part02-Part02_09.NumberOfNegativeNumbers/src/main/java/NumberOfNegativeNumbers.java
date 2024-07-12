
import java.util.Scanner;

public class NumberOfNegativeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = 0;
            int numNegNums = 0;

            while (true) {
                System.out.println("Give a number:");
                userNum = Integer.valueOf(scanner.nextLine());
                if (userNum == 0) {
                    break;
                }

                if (userNum < 0) {
                    numNegNums = numNegNums + 1;
                }

            }
            System.out.println("Number of negative numbers: " + numNegNums);

        } finally {
            scanner.close();
        }

    }
}

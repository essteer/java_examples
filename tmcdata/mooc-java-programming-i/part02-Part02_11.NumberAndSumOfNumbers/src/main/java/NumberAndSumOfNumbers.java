
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = 0;
            int sum = 0;
            int numNums = 0;

            while (true) {
                System.out.println("Give a number:");
                userNum = Integer.valueOf(scanner.nextLine());
                if (userNum == 0) {
                    break;
                }

                sum = sum + userNum;
                numNums = numNums + 1;

            }

            System.out.println("Number of numbers: " + numNums);
            System.out.println("Sum of the numbers: " + sum);

        } finally {
            scanner.close();
        }

    }
}

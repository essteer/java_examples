
import java.util.Scanner;

public class AverageOfNumbers {

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

            if (numNums > 0) {
                double average = (double) sum / numNums;
                System.out.println("Average of the numbers: " + average);
            }

        } finally {
            scanner.close();
        }

    }
}


import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = 0;
            int sum = 0;
            int numPosNums = 0;

            while (true) {
                System.out.println("Give a number:");
                userNum = Integer.valueOf(scanner.nextLine());
                if (userNum == 0) {
                    break;
                }

                if (userNum > 0) {
                    sum = sum + userNum;
                    numPosNums = numPosNums + 1;
                }
            }

            if (numPosNums > 0) {
                double average = (double) sum / numPosNums;
                System.out.println(average);
            } else {
                System.out.println("Cannot calculate the average");
            }

        } finally {
            scanner.close();
        }

    }
}

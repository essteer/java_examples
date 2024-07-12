
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = 0;
            int numNums = 0;

            while (true) {
                System.out.println("Give a number:");
                userNum = Integer.valueOf(scanner.nextLine());
                if (userNum == 0) {
                    break;
                }

                numNums = numNums + 1;
            }
            System.out.println("Number of numbers: " + numNums);

        } finally {
            scanner.close();
        }
        

    }
}

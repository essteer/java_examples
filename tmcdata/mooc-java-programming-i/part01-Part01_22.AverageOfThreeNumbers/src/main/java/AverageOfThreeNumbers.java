
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        try {
            System.out.println("Give the first number:");
            int num1 = Integer.valueOf(scanner.nextLine());
            System.out.println("Give the second number:");
            int num2 = Integer.valueOf(scanner.nextLine());
            System.out.println("Give the third number:");
            int num3 = Integer.valueOf(scanner.nextLine());
            double result = (double) (num1 + num2 + num3) / 3;
            System.out.println("The average is " + result);

        } finally {
            scanner.close();
        }

    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearsSum = 0;
        int count = 0;
        int longestNameLength = 0;
        String longestName = "";

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")) {
                break;
            }

            String[] parts = input.split(",");
            yearsSum += Integer.valueOf(parts[1]);
            count++;

            if (parts[0].length() > longestNameLength) {
                longestNameLength = parts[0].length();
                longestName = parts[0];
            }

        }
        System.out.println("Longest name: " + longestName);

        double average = (double) yearsSum / count;
        System.out.println("Average of the birth years: " + average);

    }
}

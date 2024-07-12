
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here

        ArrayList<String> numbers = new ArrayList<>();

        System.out.println("Input numbers, type 'end' to stop.");

        while (true) {
            String num = scanner.nextLine();
            if (num.equals("end")) {
                break;
            }
            numbers.add(num);
        }

        double average = numbers.stream().mapToInt(s -> Integer.valueOf(s)).average().getAsDouble();

        System.out.println("average of the numbers: " + average);

    }
}

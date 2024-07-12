
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        ArrayList<String> posNums = new ArrayList<>();
        ArrayList<String> negNums = new ArrayList<>();

        System.out.println("Input numbers, type 'end' to stop.");

        while (true) {
            String num = scanner.nextLine();
            if (num.equals("end")) {
                break;
            }
            if (Integer.valueOf(num) >= 0) {
                posNums.add(num);
            } else {
                negNums.add(num);
            }
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String command = scanner.nextLine();
        if (command.equals("p")) {
            double average = posNums.stream().mapToInt(s -> Integer.valueOf(s)).average().getAsDouble();
            System.out.println("average of the positive numbers: " + average);
        } else if (command.equals("n")) {
            double average = negNums.stream().mapToInt(s -> Integer.valueOf(s)).average().getAsDouble();
            System.out.println("average of the negative numbers: " + average);
        }
    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (Integer.valueOf(input) < 0) {
                break;
            }
            numbers.add(input);
        }

        numbers.stream()
            .filter(x -> Integer.valueOf(x) >= 1 && Integer.valueOf(x) <= 5)
            .forEach(x -> System.out.println(x));

    }
}


import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random luckyDraw = new Random();

        System.out.println("How many random numbers? ");
        int n = Integer.valueOf(scanner.nextLine());

        for (int i=0; i < n; i++) {
            System.out.println(luckyDraw.nextInt(11));
        }
    }

}

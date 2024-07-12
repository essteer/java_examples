
import java.util.Scanner;

public class Counting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int userNum = Integer.valueOf(scanner.nextLine());

            for (int i=0; i<=userNum; i++) {
                System.out.println(i);
            }

        } finally {
            scanner.close();
        }

    }
}

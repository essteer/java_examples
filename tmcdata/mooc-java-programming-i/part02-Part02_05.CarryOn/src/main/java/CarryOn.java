
import java.util.Scanner;

public class CarryOn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String carryOn = "yes";

        try {
            while (true) {

                System.out.println("Shall we carry on?");
                carryOn = scanner.nextLine();
                if (carryOn.equals("no")) {
                    break;
                }
            }
            
        } finally {
            scanner.close();
        }

    }
}

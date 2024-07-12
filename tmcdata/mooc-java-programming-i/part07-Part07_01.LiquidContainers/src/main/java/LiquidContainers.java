
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int container1 = 0;
        int container2 = 0;

        while (true) {
            System.out.print("> ");

            System.out.println("First: " + container1 + "/100");
            System.out.println("Second: " + container2 + "/100");

            String input = scan.nextLine();

            if (input.equals("quit")) {
                break;
            }

            String command = input.split(" ")[0];
            int amount = Integer.valueOf(input.split(" ")[1]);

            if (!(amount > 0)) {
                continue;
            }

            if (command.equals("add")) {

                if (container1 + amount > 100) {
                    container1 = 100;
                } else {
                    container1 += amount;
                }

            } else if (command.equals("move")) {

                if (amount > container1) {
                    amount = container1;
                }
                if (container2 + amount > 100) {
                    container2 = 100;
                } else {
                    container2 += amount;
                }
                container1 -= amount;

            } else if (command.equals("remove")) {

                if (amount > container2) {
                    container2 = 0;
                } else {
                    container2 -= amount;
                }
            }

        }
    }

}

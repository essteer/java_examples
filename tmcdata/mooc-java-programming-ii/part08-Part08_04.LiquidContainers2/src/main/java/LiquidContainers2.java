
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container cOne = new Container();
        Container cTwo = new Container();

        while (true) {
            System.out.print("> ");

            System.out.println("First: " + cOne);
            System.out.println("Second: " + cTwo);

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

                cOne.add(amount);

            } else if (command.equals("move")) {

                if (amount > cOne.contains()) {
                    amount = cOne.contains();
                }

                cOne.remove(amount);
                cTwo.add(amount);

            } else if (command.equals("remove")) {

                cTwo.remove(amount);
            }

        }
    }

}

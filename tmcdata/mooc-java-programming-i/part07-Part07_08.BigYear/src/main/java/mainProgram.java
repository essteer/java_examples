
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        Database db = new Database();

        while (true) {

            System.out.print("? ");
            String command = scan.nextLine();

            if (command.equals("Quit")) {
                break;
            }
            if (command.equals("Add")) {
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Name in Latin: ");
                String latin = scan.nextLine();
                db.add(name, latin);
                continue;
            }
            if (command.equals("All")) {
                db.printAllBirds();
                continue;
            }
            if (command.equals("One")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                db.printOneBird(name);
                continue;
            }
            if (command.equals("Observation")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                db.observation(name);
            }


        }
        scan.close();
    }
}

import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {

        Scanner scan = this.scanner;

        while (true) {
            System.out.println("Command: ");
            String command = scan.nextLine();

            if (command.equals("end")) {

                System.out.println("Bye bye!");
                break;

            } else if (command.equals("add")) {

                System.out.println("Word: ");
                String word = scan.nextLine();
                System.out.println("Translation: ");
                String translation = scan.nextLine();
                this.dictionary.add(word, translation);

            } else if (command.equals("search")) {

                System.out.println("To be translated: ");
                String target = scan.nextLine();

                if (this.dictionary.translate(target) == null) {
                    System.out.println("Word " + target + " was not found");
                } else {
                    System.out.println("Translation: " + this.dictionary.translate(target));
                }

            } else {
                System.out.println("Unknown command");
            }

        }
    }
}

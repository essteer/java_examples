
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> items = new ArrayList<>();

        while (true) {

            System.out.println("Identifier? (empty will stop)");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                break;
            }
            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            boolean duplicate = false;

            for (String item : items) {

                String[] parts = item.split(",");
                if (parts[0].equals(id)) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate == false) {
                // No matches, so add to list
                String listItem = id + "," + name;
                items.add(listItem);
            }
        }

        System.out.println("==Items==");
        for (String item : items) {
            String[] parts = item.split(",");
            System.out.println(parts[0] + ": " + parts[1]);
        }

    }
}

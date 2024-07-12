
import java.util.ArrayList;
import java.util.Scanner;

public class Items {

    public static void main(String[] args) {
        // implement here your program that uses the class Item

        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            Item newItem = new Item(name);
            items.add(newItem);
        }

        for (Item i : items) {
            System.out.println(i);
        }
    }
}


import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printValues(HashMap<String,Book> hashmap) {
        for (Book value : hashmap.values()) {
            System.out.println(value.toString());
        }
    }

    public static void printValueIfNameContains(HashMap<String,Book> hashmap, String text) {
        for (Book value : hashmap.values()) {
            if (value.getName().contains(text)) {
                System.out.println(value.toString());
            }
        }
    }
}

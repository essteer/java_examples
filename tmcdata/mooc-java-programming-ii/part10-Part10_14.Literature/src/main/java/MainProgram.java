import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookTitle = scanner.nextLine();
            if (bookTitle.isEmpty()) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            String age = scanner.nextLine();
            System.out.println();

            books.add(new Book(bookTitle, Integer.valueOf(age)));
        }
        System.out.println();
        System.out.println(books.size() + " books in total.");
        System.out.println();
        System.out.println("Books:");

        Comparator<Book> comparator = Comparator.comparing(Book::getAge).thenComparing(Book::getTitle);
        Collections.sort(books, comparator);

        books.stream().map(book -> book.toString())
                .forEach(book -> System.out.println(book));

        scanner.close();

    }

}

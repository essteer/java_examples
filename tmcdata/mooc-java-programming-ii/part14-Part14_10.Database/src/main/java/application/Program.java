package application;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {
        String databasePath = "jdbc:h2:./todo-database";
        if (args.length > 0) {
            databasePath = args[0];
        }

        TodoDao database = new TodoDao(databasePath);
        Scanner scanner = new Scanner(System.in);

        new UserInterface(scanner, database).start();
    }
}


// Scanner s = new Scanner(System.in);
// TodoDao td = new TodoDao("jdbc:h2:./databaseFile");
// td.add(new Todo("Socrates", "is mortal", Boolean.FALSE));
// td.add(new Todo("six", "is a dog", Boolean.FALSE));
// UserInterface ui = new UserInterface(s, td);
// ui.start();

// Scanner s = new Scanner(System.in);
// TodoDao td = new TodoDao("jdbc:h2:./databaseFile");
// td.add(new Todo("46a7", "46a7 is something", Boolean.FALSE));
// td.add(new Todo("710a", "710a is another thing", Boolean.FALSE));
// UserInterface ui = new UserInterface(s, td);
// ui.start();
package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here

            switch (command) {
                case "1":
                    System.out.println("Listing the database contents");
                    for (Todo todo : this.database.list()) {
                        System.out.println(todo.toString());
                    }
                    break;
                case "2":
                    System.out.println("Adding a new todo");
                    System.out.println("Enter name");
                    String name = this.scanner.nextLine();
                    System.out.println("Enter description");
                    String desc = this.scanner.nextLine();
                    int id = this.database.list().size();
                    this.database.add(new Todo(id, name, desc, false));
                    break;
                case "3":
                    System.out.println("Which todo should be marked as done (give the id)?");
                    int idCompleted = Integer.valueOf(this.scanner.nextLine());
                    this.database.markAsDone(idCompleted);
                    break;
                case "4":
                    System.out.println("Which todo should be removed (give the id)?");
                    int idToRemove = Integer.valueOf(this.scanner.nextLine());
                    this.database.remove(idToRemove);
                    break;
            }
        }

        System.out.println("Thank you!");
    }

}


// The exercise base contains an application that has the H2 database configured as a dependency. It also includes the following four classes:

// Todo: a class that represents a task that is to be done. Each todo has a numerical identifier (id), a name, a description, and the information abot whether it has been done.
// TodoDao: a class that is used to store todos to the database. The word "dao" comes from the phrase "data access object". The class offers methods for listing, adding, setting as completed, and removing todos. Removing or setting as done is done on the basis of the id. The class constructor receives the location of the database.
// UserInterface: a class that is used to ask the user for instructions for what to do. The constructor receives a Scanner object and a TodoDao object as its parameters. Calling the start method starts the user interface, after which the user controls the program with their keyboard input.
// Program: a class that serves as a starting point for the program.

// In this exercise it is your task to modify the user interface so that the user of the program can add new todos, or list, mark as done, or remove existing ones. Don't do changes in the classes Todo, TodoDao, or Program.

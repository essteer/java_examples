import java.util.Scanner;;

public class UserInterface {

    private TodoList todolist;
    private Scanner scanner;

    public UserInterface(TodoList todolist, Scanner scanner) {
        this.todolist = todolist;
        this.scanner = scanner;
    }

    public void start() {

        Scanner scan = this.scanner;

        while (true) {

            System.out.println("Command: ");
            String command = scan.nextLine();

            if (command.equals("stop")) {
                break;
            }
            if (command.equals("add")) {

                System.out.println("To add: ");
                String toAdd = scan.nextLine();
                this.todolist.add(toAdd);

            } else if (command.equals("list")) {
                this.todolist.print();

            } else if (command.equals("remove")) {

                System.out.println("Which one is removed? ");
                int toRemove = Integer.valueOf(scan.nextLine());
                this.todolist.remove(toRemove);
            }

        }
    }
}

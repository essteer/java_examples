package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter title: ");
        String customTitle = scanner.nextLine();

        String titleParam = "--title=" + customTitle; 
        
        Application.launch(UserTitle.class,
            titleParam);
        

        scanner.close();
    }

}


// Write a program that asks for a title in a command line interface. When the user types the title and presses enter, the user is shown a graphical user interface with the given title.
// Notice, this exercise does not have automatic tests. Return the program once it works as described in the exercise.
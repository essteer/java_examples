
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Write your program here -- consider breaking the program into 
        // multiple classes.
        Student user = new Student();
        System.out.println("Enter point totals, -1 stops:");

        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            // -1 to exit
            if (number == -1) {
                break;
            }
            user.addPoints(number);
        }

        double averageAll = user.averageAll();
        System.out.println("Point average (all): " + averageAll);

        double averagePassing = user.averagePassing();
        if (averagePassing == 0.0) {
            System.out.println("Point average (passing): -");
            System.out.println("Pass percentage: 0.0");
        } else {
            System.out.println("Point average (passing): " + averagePassing);
            double percentPassing = user.percentPassing();
            System.out.println("Pass percentage: " + percentPassing);
        }

        String[] gradeDist = user.gradeDistribution();
        System.out.println("Grade distribution:");
        for (int i = gradeDist.length - 1; i >= 0; i--) {
            System.out.println(i + ": " + gradeDist[i]);
        }
    }
}

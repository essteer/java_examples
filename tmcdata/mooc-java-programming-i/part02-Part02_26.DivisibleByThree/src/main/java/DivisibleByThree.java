
import java.util.Scanner;

public class DivisibleByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // try {
        //     int b = Integer.valueOf(scanner.nextLine());
        //     int e = Integer.valueOf(scanner.nextLine());

        // } finally {
        //     scanner.close();
        // }

    }
    
    public static void divisibleByThreeInRange(int beginning, int end) {
        
        for (int i=beginning; i<=end; i++) {
            if (i%3 == 0) {
                System.out.println(i);
            }
        }
    }
        


}

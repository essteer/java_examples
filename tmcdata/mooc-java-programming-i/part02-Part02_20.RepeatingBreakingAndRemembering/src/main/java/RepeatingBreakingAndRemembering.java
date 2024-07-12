
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        
        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.
        
        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.
        
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Give numbers:");
            int userNum = Integer.valueOf(scanner.nextLine());
            int sum = 0;
            int numNums = 0;
            int numEven = 0;
            int numOdd = 0;

            while (userNum != -1) {
                
                sum += userNum;
                numNums++;
                if (userNum % 2 == 0) {
                    numEven++;
                } else {
                    numOdd++;
                }

                userNum = Integer.valueOf(scanner.nextLine());
            }
            
            System.out.println("Thx! Bye!");
            System.out.println("Sum: " + sum);
            System.out.println("Numbers: " + numNums);

            double average = (double) sum / numNums;
            System.out.println("Average: " + average);

            System.out.println("Even: " + numEven);
            System.out.println("Odd: " + numOdd);

        } finally {
            scanner.close();
        }

    }
}

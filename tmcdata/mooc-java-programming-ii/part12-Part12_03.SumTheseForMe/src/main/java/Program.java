
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        // calculate the sum of the elements in the array between the lower and the upper limits
        // Only numbers smaller or equal to the int largest and larger or equal to the int smallest are added to the sum
        if (fromWhere < 0) {
            fromWhere = 0;
        }
        if (toWhere > array.length) {
            toWhere = array.length;
        }
        int total = 0;
        for (int i = fromWhere; i < toWhere; i++) {
            if (array[i] <= largest && array[i] >= smallest) {
                total += array[i];
            }
        }
        return total;
    }
}

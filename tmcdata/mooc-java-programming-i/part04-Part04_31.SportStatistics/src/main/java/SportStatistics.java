
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> matches = new ArrayList<>();

        System.out.println("File: ");
        String file = scan.nextLine();
        System.out.println("Team: ");
        String team = scan.nextLine();

        try (Scanner reader = new Scanner(Paths.get(file))) {

            int count = 0;
            int wins = 0;
            int losses = 0;

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                if (line.contains(team)) {
                    count += 1;

                    String[] result = line.split(",");
                    if ((team.equals(result[0]) && Integer.valueOf(result[2]) > Integer.valueOf(result[3])) ||
                            (team.equals(result[1]) && Integer.valueOf(result[3]) > Integer.valueOf(result[2]))) {
                        wins += 1;
                    } else {
                        losses += 1;
                    }
                }
            }
            System.out.println("Games: " + count);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);

        } catch (Exception e) {
            System.out.println("Reading the file " + file + " failed.");
        }

    }

}


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {

        ArrayList<String[]> statistics = new ArrayList<>();

        try {
            Files.lines(Paths.get("literacy.csv"))
            // Convert each line to an array, split by the commas
            .map(stats -> stats.split(","))
            // Add each array to the ArrayList
            .forEach(stats -> statistics.add(stats));
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        statistics.stream()
        // Sort each array by the value of its 5th element (the literacy rate)
        .sorted((stat1, stat2) -> Double.valueOf(stat1[5]).compareTo(Double.valueOf(stat2[5])))
        // Map the sorted arrays to retrieve only the desired values
        .map(stats -> stats[3].trim() + " (" + stats[4].trim() + "), " + stats[2].split(" ")[1] + ", " + stats[5].trim())
        // Print each array in order
        .forEach(stat -> System.out.println(stat));

    }
}

// ArrayList<Result> results = new ArrayList<>();
//         try {
//             Files.lines(Paths.get("literacy.csv"))
//                     .map(l -> l.split(","))
//                     .map(a -> new Result(a[2].replace("(%)", "").trim(), a[3], Integer.valueOf(a[4]), Double.parseDouble(a[5])))
//                     .forEach(t -> results.add(t));
//         } catch (IOException ex) {
//             System.out.println("Error reading file.");
//         }
        
//         results.stream().sorted((t1, t2) -> {
//             if (t1.getLiteracyPercent() > t2.getLiteracyPercent()) {
//                 return 1;
//             }
//             if (t1.getLiteracyPercent() < t2.getLiteracyPercent()) {
//                 return -1;
//             }
//             return 0;
//         }).forEach(t -> System.out.println(t));
//     }
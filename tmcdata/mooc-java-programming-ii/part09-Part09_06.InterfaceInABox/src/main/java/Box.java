import java.util.ArrayList;

public class Box implements Packable {

    private double maxCapacity;
    private ArrayList<Packable> boxContents;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.boxContents = new ArrayList<>();
    }

    public void add(Packable item) {
        double totalWeight = 0;
        for (Packable packable : this.boxContents) {
            totalWeight += packable.weight();
        }
        if (totalWeight + item.weight() <= this.maxCapacity) {
            boxContents.add(item);
        }

    }

    public double weight() {
        double totalWeight = 0;
        for (Packable packable : this.boxContents) {
            totalWeight += packable.weight();
        }
        return totalWeight;
    }

    public String toString() {
        double totalWeight = 0;
        for (Packable packable : this.boxContents) {
            totalWeight += packable.weight();
        }
        return "Box: " + this.boxContents.size() + " items, total weight " + totalWeight + " kg";
    }
}

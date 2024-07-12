import java.util.ArrayList;

public class Hold {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        int currentWeight = 0;
        for (Suitcase luggage : suitcases) {
            currentWeight += luggage.totalWeight();
        }
        if (currentWeight + suitcase.totalWeight() <= this.maxWeight) {
            this.suitcases.add(suitcase);
        }
    }

    public void printItems() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printItems();
        }
    }

    public String toString() {
        int currentWeight = 0;
        for (Suitcase luggage : suitcases) {
            currentWeight += luggage.totalWeight();
        }
        return this.suitcases.size() + " suitcases (" + currentWeight + " kg)";
    }
}

import java.util.ArrayList;

public class Suitcase {

    private int maxWeight;
    private ArrayList<Item> items;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (!(totalWeight() + item.getWeight() > maxWeight)) {
            this.items.add(item);
        }
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Item item : this.items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public Item heaviestItem() {
        if (this.items.size() == 0) {
            return null;
        }
        Item returnObject = this.items.get(0);
        for (Item item : items) {
            if (item.getWeight() > returnObject.getWeight()) {
                returnObject = item;
            }
        }
        return returnObject;
    }

    public String toString() {

        if (this.items.size() == 0) {
            return "no items (0 kg)";
        }

        int totalWeight = 0;
        for (Item item : this.items) {
            totalWeight += item.getWeight();
        }

        if (this.items.size() == 1) {
            return this.items.size() + " item (" + totalWeight + " kg)";
        }
        return this.items.size() + " items (" + totalWeight + " kg)";
    }
}

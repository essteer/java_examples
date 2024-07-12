import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> contents;

    public BoxWithMaxWeight(int capacity) {
        super();
        this.capacity = capacity;
        this.contents = new ArrayList<>();
    }

    public void add(Item item) {
        int currentWeight = 0;
        for (Item content : contents) {
            currentWeight += content.getWeight();
        }
        if (currentWeight + item.getWeight() <= this.capacity) {
            contents.add(item);
        }
    }

    public boolean isInBox(Item item) {
        for (Item content : contents) {
            if (content.equals(item)) {
                return true;
            }
        }
        return false;
    }

}

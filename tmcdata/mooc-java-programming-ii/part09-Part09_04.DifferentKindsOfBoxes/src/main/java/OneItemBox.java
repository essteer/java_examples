import java.util.ArrayList;

public class OneItemBox extends Box {

    private ArrayList<Item> contents;

    public OneItemBox() {
        super();
        this.contents = new ArrayList<>();
    }

    public void add(Item item) {
        if (contents.size() == 0) {
            contents.add(item);
        }
    }

    public boolean isInBox(Item item) {
        if (contents.size() == 1 && contents.get(0).equals(item)) {
            return true;
        }
        return false;
    }

}


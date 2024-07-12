public class MisplacingBox extends Box {

    public MisplacingBox() {
        super();
    }

    public void add(Item item) {
        return;
    }

    public boolean isInBox(Item item) {
        return false;
    }

}

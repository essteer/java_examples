import java.util.ArrayList;

public class Hideout<T> {

    private ArrayList<T> stash;

    public Hideout() {
        this.stash = new ArrayList<>();
    }

    public void putIntoHideout(T toHide) {
        if (stash.size() != 0) {
            this.stash = new ArrayList<>();
        }
        this.stash.add(toHide);
    }

    public T takeFromHideout() {
        if (stash.size() == 0) {
            return null;
        }
        T swag = this.stash.get(0);
        this.stash = new ArrayList<>();
        return swag;
    }

    public boolean isInHideout() {
        return this.stash.size() == 1;
    }

}

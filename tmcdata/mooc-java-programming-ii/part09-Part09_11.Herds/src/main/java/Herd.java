import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {

    private List<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>(); 
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable org : this.herd) {
            org.move(dx, dy);
        }
    }

    public String toString() {
        String output = "";
        for (Movable org : this.herd) {
            output += org.toString() + "\n";
        }
        return output;
    }

}

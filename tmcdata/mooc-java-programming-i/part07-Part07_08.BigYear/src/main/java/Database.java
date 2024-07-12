import java.util.ArrayList;

public class Database {

    private ArrayList<Bird> birdsDatabase;

    public Database() {
        this.birdsDatabase = new ArrayList<>();
    }

    public void add(String name, String latinName) {
        Bird newBird = new Bird(name, latinName);
        if (!(this.birdsDatabase.contains(newBird))) {
            this.birdsDatabase.add(newBird);
        }

    }

    public void observation(String name) {
        for (Bird bird : this.birdsDatabase) {
            if (bird.getName().equals(name)) {
                bird.addCount();
                return;
            }
        System.out.println("Not a bird!");
        }
    }

    public void printBird(Bird bird) {
        System.out.println(bird);
    }

    public void printOneBird(String name) {
        for (Bird bird : this.birdsDatabase) {
            if (bird.getName().equals(name)) {
                printBird(bird);
                return;
            }
        System.out.println("Not a bird!");
        }
    }

    public void printAllBirds() {
        for (Bird bird : birdsDatabase) {
            printBird(bird);
        }
    }

}

public class Bird {

    private String name;
    private String latinName;
    private int count;

    public Bird(String name, String latinName) {
        this(name, latinName, 0);
    }

    public Bird(String name, String latinName, int count) {
        this.name = name;
        this.latinName = latinName;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public void addCount() {
        this.count += 1;
    }

    public String toString() {
        return this.name + "(" + this.latinName + "): " + this.count + "observations";
    }
}

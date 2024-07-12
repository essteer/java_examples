public class Cat extends Animal implements NoiseCapable {

    private String name;

    public Cat(String name) {
        super(name);
        this.name = name;
    }

    public Cat() {
        this("Cat");
    }

    public void purr() {
        System.out.println(this.name + " purrs");

    }

    @Override
    public void makeNoise() {
        this.purr();
    }

}

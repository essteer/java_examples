public class Dog extends Animal implements NoiseCapable {

    private String name;

    public Dog(String name) {
        super(name);
        this.name = name;
    }

    public Dog() {
        this("Dog");
    }

    public void bark() {
        System.out.println(this.name + " barks");

    }

    @Override
    public void makeNoise() {
        this.bark();
    }

}


import java.util.Objects;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;

    public Person(String name, SimpleDate birthday, int height, int weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    // implement an equals method here for checking the equality of objects
    public boolean equals(Object compared) {

        if (this == compared) {
            return true;
        }
        // if the type of the compared object is not Person, the objects are not equal
        if (!(compared instanceof Person)) {
            return false;
        }
        // convert the Object type compared object
        // into a Person type object called comparedPerson
        Person comparedPerson = (Person) compared;

        // if the values of the object variables are the same, the objects are equal
        if (this.name.equals(comparedPerson.name) &&
            this.height == comparedPerson.height &&
            this.weight == comparedPerson.weight &&
            this.birthday.getYear() == comparedPerson.birthday.getYear() &&
            this.birthday.getMonth() == comparedPerson.birthday.getMonth() &&
            this.birthday.getDay() == comparedPerson.birthday.getDay()) {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }
}

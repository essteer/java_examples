import java.util.ArrayList;

public class Room {

    private ArrayList<Person> persons;

    public Room() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public boolean isEmpty() {
        return this.persons.isEmpty();
    }

    public ArrayList<Person> getPersons() {
        return this.persons;
    }

    public Person shortest() {
        if (this.persons.isEmpty()) {
            return null;
        }

        Person toReturn = this.persons.get(0);
        for (Person person : persons) {
            if (person.getHeight() < toReturn.getHeight()) {
                toReturn = person;
            }
        }
        return toReturn;
    }

    public Person take() {
        Person shortest = this.shortest();
        
        for (int i=0; i<this.persons.size(); i++) {
            if (this.persons.get(i).equals(shortest)) {
                return this.persons.remove(i);
            }
        }
        return shortest;

        // Person shortestPerson = shortest();
        // this.persons.remove(shortestPerson);
        // return shortestPerson;
    }

}

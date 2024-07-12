
public class HealthStation {

    private int weighings;


    public int weigh(Person person) {
        // return the weight of the person passed as the parameter
        this.weighings += 1;
        return person.getWeight();
    }

    public void feed(Person person) {

        int currentWeight = weigh(person);
        person.setWeight(currentWeight + 1);

    }

    public int weighings() {

        return this.weighings;

    }


}


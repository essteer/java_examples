
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String longest() {
        if (this.elements.isEmpty()) {
            return null;
        }

        String returnObject = this.elements.get(0);
        int longest = returnObject.length();

        for (String e : this.elements) {
            if (e.length() > longest) {
                returnObject = e;
                longest = e.length();
            }
        } 
        return returnObject;
    }

}

// The exercise template comes with the class SimpleCollection that's familiar from previous exercises. Implement the method public String longest() for the class, which returns the longest string of the collection. If the collection is empty, the method should return a null reference.

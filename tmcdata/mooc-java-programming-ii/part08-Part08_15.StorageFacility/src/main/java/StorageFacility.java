import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String,ArrayList<String>> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.facility.putIfAbsent(unit, new ArrayList<>());
        this.facility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.facility.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> contents = this.facility.get(storageUnit);
        boolean lastItem = (contents.size() == 1);
        
        for (String content : contents) {
            if (content.equals(item)) {
                contents.remove(item);
                if (lastItem) {
                    this.facility.remove(storageUnit);
                }
                break;
            }
        }

    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsInUse = new ArrayList<>();
        for (String unit : this.facility.keySet()) {
            if (this.facility.get(unit).size() > 0) {
                unitsInUse.add(unit);
            }
        }
        return unitsInUse;
    }
}


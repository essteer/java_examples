import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate,String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.containsKey(licensePlate)) {
            return false;
        }
        this.registry.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return this.registry.getOrDefault(licensePlate, null);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!(registry.containsKey(licensePlate))) {
            return false;
        }
        registry.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate plate : this.registry.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> printed = new ArrayList<>();
        for (LicensePlate plate : this.registry.keySet()) {
            if (!(printed.contains(this.registry.get(plate)))) {
                printed.add(this.registry.get(plate));
                System.out.println(this.registry.get(plate));
            }
        }
    }
}

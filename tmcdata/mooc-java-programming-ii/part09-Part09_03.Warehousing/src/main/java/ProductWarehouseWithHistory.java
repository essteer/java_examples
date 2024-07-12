public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        super.addToWarehouse(initialBalance);
        history.add(initialBalance);
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double balance = super.takeFromWarehouse(amount);
        history.add(super.getBalance());
        return balance;
    }

    public String history() {
        return history.toString();
    }

    public void printAnalysis() {
        String output = "Product: " + super.getName() + "\n";
        output += "History: " + history() + "\n";
        output += "Largest amount of product: " + history.maxValue() + "\n";
        output += "Smallest amount of product: " + history.minValue() + "\n";
        output += "Average: " + history.average();
        System.out.println(output); 
    }

}

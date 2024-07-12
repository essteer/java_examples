import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        this.history = new ArrayList<>();
    }

    public double maxValue() {
        double max = 0;
        for (Double value : history) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public double minValue() {
        if (history.size() == 0) {
            return 0;
        }
        double min = history.get(0);
        for (Double value : history) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public double average() {
        if (history.size() == 0) {
            return 0;
        }
        double total = 0.0;
        for (Double value : history) {
            total += value;
        }
        return total / history.size();
    }

    public String toString() {
        return history.toString();
    }

}

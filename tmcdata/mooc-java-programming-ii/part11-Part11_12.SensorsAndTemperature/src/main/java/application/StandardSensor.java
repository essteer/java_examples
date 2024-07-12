package application;

public class StandardSensor implements Sensor {

    private int reading;

    public StandardSensor(int reading) {
        this.reading = reading;
    }

    public boolean isOn() {
        return true;
    }

    public void setOn() {
    }

    public void setOff() {
    }

    public int read() {
        return this.reading;
    }

}

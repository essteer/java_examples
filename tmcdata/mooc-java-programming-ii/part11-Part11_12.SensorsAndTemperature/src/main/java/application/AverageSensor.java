package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensorList;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensorList = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public boolean isOn() {
        for (Sensor sensor : sensorList) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    public void setOn() {
        for (Sensor sensor : sensorList) {
            if (!sensor.isOn()) {
                sensor.setOn();
            }
        }
    }

    public void setOff() {
        for (Sensor sensor : sensorList) {
            if (sensor.isOn()) {
                sensor.setOff();
            }
        }
    }

    @Override
    public int read() {
        if (this.sensorList.isEmpty() || !this.isOn()) {
            throw new IllegalStateException();
        }
        int sum = 0;
        for (Sensor sensor : this.sensorList) {
            sum += sensor.read();
        }
        int average = sum / this.sensorList.size();
        this.readings.add(average);
        return average;
    }

    public void addSensor(Sensor toAdd) {
        this.sensorList.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;
    }

}

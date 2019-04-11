package Devices;

// Плита
public class Stove extends Device {
    private boolean open = false;
    private int temperature = 0;

    public int getTemperature() {
        return temperature;
    }

    private Stove() {
    }

    public Stove(String id) {
        name = "Stove";
        this.identificator = id;
    }

    public Stove(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        this.temperature = temperature;
    }
}

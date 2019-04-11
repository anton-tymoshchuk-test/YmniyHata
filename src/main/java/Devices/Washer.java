package Devices;

// Пральна машина
public class Washer extends Device {
    private boolean open = false;
    private int temperature = 0;
    private int washMode = 0;
    private int speed = 0;

    public int getTemperature() {
        return temperature;
    }

    public int getWashMode() {
        return washMode;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOpen() {
        return open;
    }

    private Washer() {
    }

    public Washer(String id) {
        name = "Washer";
        this.identificator = id;
    }

    public Washer(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void selectWashMode(int washMode) {
        this.washMode = washMode;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

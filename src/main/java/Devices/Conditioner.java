package Devices;

// Кондиціонер
public class Conditioner extends Device {
    private boolean open = false;
    private int temperature = 0;
    private int flowSpeed = 0; // Швидкість потоку повітря
    private int windAngle = 45;

    public int getTemperature() {
        return temperature;
    }

    public int getFlowSpeed() {
        return flowSpeed;
    }

    public int getWindAngle() {
        return windAngle;
    }

    private Conditioner() {
    }

    public Conditioner(String id) {
        name = "Conditioner";
        this.identificator = id;
    }

    public Conditioner(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void selectFlowSpeed(int flowSpeed) {
        this.flowSpeed = flowSpeed;
    }

    public void selectWindAngle(int windAngle) {
        this.windAngle = windAngle;
    }
}

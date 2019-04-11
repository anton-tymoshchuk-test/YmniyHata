package Devices;

import java.util.Random;

// Пральна машина
public class Washer extends Device {
    private boolean open = false;
    private int temperature = 0;
    private int washMode = 1;
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

    public void randomizeData() {
        if (!enabled) {
            open = true;
            temperature = 0;
            washMode = 1;
            speed = 0;
            return;
        }
        Random random = new Random();
        open = false;
        temperature = random.nextInt(20) + 10;
        washMode = random.nextInt(5);
        speed = random.nextInt(30) + 30;
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        if (temperature >= 10 && temperature <= 20)
            this.temperature = temperature;
    }

    public void selectWashMode(int washMode) {
        if (washMode >= 1 && washMode <= 5)
            this.washMode = washMode;
    }

    public void setSpeed(int speed) {
        if (speed >= 30 && speed <= 60)
            this.speed = speed;
    }
}

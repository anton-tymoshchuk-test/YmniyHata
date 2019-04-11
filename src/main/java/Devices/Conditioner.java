package Devices;

import java.util.Random;

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

    public void randomizeData() {
        if (!enabled) {
            open = false;
            temperature = 0;
            flowSpeed = 0;
            windAngle = 0;
            usingElectricity = 0;
            return;
        }
        Random random = new Random();
        open = true;
        usingElectricity = random.nextFloat() * 250;
        temperature = random.nextInt(37);
        flowSpeed = random.nextInt(10) + 2;
        windAngle = random.nextInt(90);
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        if (temperature >= 0 && temperature <= 37)
            this.temperature = temperature;
    }

    public void selectFlowSpeed(int flowSpeed) {
        if (flowSpeed >= 2 && flowSpeed <= 12)
            this.flowSpeed = flowSpeed;
    }

    public void selectWindAngle(int windAngle) {
        if (windAngle >= 0 && windAngle <= 90)
            this.windAngle = windAngle;
    }
}

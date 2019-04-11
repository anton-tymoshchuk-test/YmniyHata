package Devices;

import java.util.Random;

public class Fridge extends Device {
    private boolean open = false;
    private int temperature = 0;

    public boolean isOpen() {
        return open;
    }

    public int getTemperature() {
        return temperature;
    }

    private Fridge() {
    }

    public Fridge(String id) {
        name = "Fridge";
        this.identificator = id;
    }

    public Fridge(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void randomizeData() {
        if (!enabled) {
            open = true;
            temperature = 0;
            usingElectricity = 0;
            return;
        }
        open = false;
        Random random = new Random();
        usingElectricity = random.nextFloat() * 250;
        temperature = random.nextInt(18);
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        if (temperature >= 0 && temperature <= 18)
            this.temperature = temperature;
    }
}

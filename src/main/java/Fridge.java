import java.awt.*;

public class Fridge extends Device {
    private String name;
    private boolean on;
    private boolean open;
    private int temperature;

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    public boolean isOpen() {
        return open;
    }

    public int getTemperature() {
        return temperature;
    }

    public Fridge() {
        name = "Fridge";
    }

    public void onOff() {
        on = !on;
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        this.temperature = temperature;
    }
}

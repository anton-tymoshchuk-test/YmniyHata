import java.awt.*;

public class Fridge extends Device {
    private boolean open;
    private int temperature;

    public boolean isOpen() {
        return open;
    }

    public int getTemperature() {
        return temperature;
    }

    public Fridge() {
        name = "Fridge";
    }

    public void openClose() {
        open = !open;
    }

    public void selectTemperature(int temperature) {
        this.temperature = temperature;
    }
}

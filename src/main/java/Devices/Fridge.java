package Devices;

public class Fridge extends Device {
    private boolean open = false;
    private int temperature = 0;

    public boolean isOpen() {
        return open;
    }

    public int getTemperature() {
        return temperature;
    }

    private Fridge(){}
    public Fridge(String id)
    {
        name = "Fridge";
        this.identificator = id;
    }
    public Fridge(String id,String name)
    {
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

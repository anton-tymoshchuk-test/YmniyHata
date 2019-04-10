import java.io.Serializable;
        import java.util.List;

public abstract class Device implements Serializable {
    String name = null;
    boolean on = false;
    float usingElectricity = 0;

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    List<Float> history;
    void updateHistory()
    {
        history.add(usingElectricity);
    }

    public void onOff() {
        on = !on;
    }
}

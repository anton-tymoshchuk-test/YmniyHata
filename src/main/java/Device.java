import java.io.Serializable;
        import java.util.List;

public abstract class Device implements Serializable {
    String name;
    boolean on;
    float usingElecticity;

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    List<Float> history;
    void updateHistory()
    {
        history.add(usingElecticity);
    }

    public void onOff() {
        on = !on;
    }
}

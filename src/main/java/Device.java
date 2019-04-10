import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Device implements Serializable {
    String name = null;
    boolean enabled = false;
    float usingElectricity = 0;
    //Історія використання енергії
    List<Float> history = new ArrayList<Float>();

    public String getName() {
        return name;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void toggleEnabled() {
        enabled = !enabled;
    }
    void updateHistory()
    {
        history.add(usingElectricity);
    }
}

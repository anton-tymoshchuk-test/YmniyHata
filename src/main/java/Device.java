import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public abstract class Device implements Serializable {
    String name = null;
    boolean enabled = false;
    float usingElectricity = 0;
    //Історія використання енергії
    Map<String,Float> history = new HashMap<String,Float>();

    public String getName() {
        return name;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void toggleEnabled() {
        enabled = !enabled;
    }
    void updateHistory(String unixtime){ history.put(unixtime,usingElectricity); }
}

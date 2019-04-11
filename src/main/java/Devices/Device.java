package Devices;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public abstract class Device implements Serializable {
    protected String name = null;
    protected boolean enabled = false;
    protected float usingElectricity = 0;
    //Історія використання енергії <unixtime,electricity>
    protected Map<String,Float> history = new HashMap<String,Float>();

    public String getName() {
        return name;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public float getElectiricty() { return usingElectricity; }
    public Map<String,Float> getHistory(){ return history; }
    public void toggleEnabled() {
        enabled = !enabled;
    }

    public void updateHistory(String unixtime){ history.put(unixtime,usingElectricity); }
}

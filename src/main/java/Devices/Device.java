package Devices;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public abstract class Device implements Serializable {
    protected String identificator;
    protected Long latestCloudUpdate;
    protected String name = "Unknown";
    protected boolean enabled = false;
    protected float usingElectricity = 0;
    //Історія використання енергії <unixtime,electricity>
    //protected Map<String,Float> history = new HashMap<String,Float>();

    public String getIdentificator() {
        return identificator;
    }

    public Long getLatestCloudUpdate() {
        return latestCloudUpdate;
    }

    public void setLatestCloudUpdate(Long latestCloudUpdate) {
        this.latestCloudUpdate = latestCloudUpdate;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public float getUsingElectricity() {
        return usingElectricity;
    }

    //public Map<String,Float> getHistory(){ return history; }
    public void toggleEnabled() {
        enabled = !enabled;
    }

    public void setUsingElectricity(float value) {
        usingElectricity = value;
    }
    public void randomizeData()
    {
        if(!enabled)
        {
            usingElectricity = 0;
            return;
        }
        Random random = new Random();
        usingElectricity = random.nextFloat() * 250;//max value  250
    }
    //public void updateHistory(String unixtime){ history.put(unixtime,usingElectricity); }
}

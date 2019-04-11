package Devices;

public class Alarm extends Device {
    private int hours = 0;
    private int minutes = 0;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    private Alarm(){}
    public Alarm(String id)
    {
        name = "Alarm";
        this.identificator = id;
    }
    public Alarm(String id,String name)
    {
        this.name = name;
        this.identificator = id;
    }

    public void setTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
}

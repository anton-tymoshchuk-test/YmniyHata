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

    public Alarm() {
        name = "Alarm";
    }

    public void setTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
}

public class Alarm extends Device {
    private String name;
    private int hours;
    private int minutes;

    public String getName() {
        return name;
    }

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

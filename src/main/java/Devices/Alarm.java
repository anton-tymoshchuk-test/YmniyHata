package Devices;

import java.util.Random;

public class Alarm extends Device {
    private int hours = 0;
    private int minutes = 0;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    private Alarm() {
    }

    public Alarm(String id) {
        name = "Alarm";
        this.identificator = id;
    }

    public Alarm(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void randomizeData() {
        if (!enabled) {
            hours = 0;
            minutes = 0;
            return;
        }
        Random random = new Random();
        hours = random.nextInt(24);
        minutes = random.nextInt(60);
    }

    public void setTime(int hours, int minutes) {
        if (hours < 24 && minutes < 60) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }
}

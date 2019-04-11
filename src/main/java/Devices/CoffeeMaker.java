package Devices;

import java.util.Random;

public class CoffeeMaker extends Device {
    private int coffeeType = 1;
    private int sugarPercent = 0;
    private boolean hasMilk = false;

    public int getCoffeeType() {
        return coffeeType;
    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public boolean isHasMilk() {
        return hasMilk;
    }

    private CoffeeMaker() {
    }

    public CoffeeMaker(String id) {
        name = "CoffeeMaker";
        this.identificator = id;
    }

    public CoffeeMaker(String id, String name) {
        this.name = name;
        this.identificator = id;
    }

    public void randomizeData() {
        if (!enabled) {
            coffeeType = 1;
            hasMilk = false;
            usingElectricity = 0;
            return;
        }
        Random random = new Random();
        coffeeType = random.nextInt(5);
        usingElectricity = random.nextFloat() * 250;
        if (sugarPercent == 0)
            sugarPercent = 100;
        sugarPercent -= 2;

        hasMilk = !hasMilk;
    }

    public String makeCoffee(int coffeeType, int sugarPercent, boolean hasMilk) {
        if (coffeeType >= 1 && coffeeType <= 4 && sugarPercent >= 0 && sugarPercent <= 100) {
            this.coffeeType = coffeeType;
            this.sugarPercent = sugarPercent;
            this.hasMilk = hasMilk;
            return "Coffee";
        }
        return "No coffee";
    }
}

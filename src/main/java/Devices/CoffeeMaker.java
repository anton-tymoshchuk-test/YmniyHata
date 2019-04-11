package Devices;

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

    private CoffeeMaker(){}
    public CoffeeMaker(String id)
    {
        name = "CoffeeMaker";
        this.identificator = id;
    }
    public CoffeeMaker(String id,String name)
    {
        this.name = name;
        this.identificator = id;
    }

    public String makeCoffie(int coffeeType, int sugarPercent, boolean hasMilk) {
        this.coffeeType = coffeeType;
        this.sugarPercent = sugarPercent;
        this.hasMilk = hasMilk;
        return "Coffee";
    }
}

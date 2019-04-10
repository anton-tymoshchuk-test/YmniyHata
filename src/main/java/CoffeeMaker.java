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

    public CoffeeMaker() {
        name = "Coffee maker";
    }

    public String makeCoffie(int coffeeType, int sugarPercent, boolean hasMilk) {
        this.coffeeType = coffeeType;
        this.sugarPercent = sugarPercent;
        this.hasMilk = hasMilk;
        return "Coffee";
    }
}

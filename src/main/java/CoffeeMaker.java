public class CoffeeMaker extends Device {
    private String name;
    private int coffeeType;
    private int sugarPercent;
    private boolean hasMilk;

    public String getName() {
        return name;
    }

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

package classes.factoryExample;

public class Bond implements Product{
    private String name;
    private double price;

    public Bond() {
        this.name = "Bond";
        this.price = 1000.0; // Default price for a bond
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

package classes.factoryExample;

public class Stock implements Product{
    private String name;
    private double price;

    public Stock() {
        this.name = "Stock";
        this.price = 1000.0; // Default price for a stock
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

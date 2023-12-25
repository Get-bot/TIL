package classes.factoryExample;

public class Loan implements Product{
    private String name;
    private double price;

    public Loan() {
        this.name = "Loan";
        this.price = 1000.0; // Default price for a loan
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

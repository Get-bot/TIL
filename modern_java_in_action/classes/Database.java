package classes;

public class Database {
    public static Customer getCustomerWithId(int id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("name" + id);
        return customer;
    }
}

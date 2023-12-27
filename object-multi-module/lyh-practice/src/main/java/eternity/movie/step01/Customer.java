package eternity.movie.step01;

public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Customer customer = new Customer("A", "B");
    }
}

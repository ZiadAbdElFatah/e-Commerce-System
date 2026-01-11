public abstract class Product {
    private String name;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Price must be positive!");
            return;
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

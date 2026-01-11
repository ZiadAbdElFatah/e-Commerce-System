import java.time.LocalDate;

abstract class Food extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Weight must be positive!");
            return;
        }
        this.weight = weight;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}

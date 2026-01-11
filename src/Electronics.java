abstract class Electronics extends Product implements Shippable {
    private double weight;

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Weight must be positive!");
            return;
        }
        this.weight = weight;
    }
}

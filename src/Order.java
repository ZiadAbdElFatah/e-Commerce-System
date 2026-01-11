import java.util.Map;

public class Order {
    private double subtotal = 0;
    private double shippingPrice = 0;
    private double shippingWeight = 0;
    private double total = 0;
    private final Cart currentOrder;

    public Order(Cart cart) {
        currentOrder = cart;
    }

    public void computeTotal() {
        subtotal = 0;
        shippingWeight = 0;
        shippingPrice = 0;
        total = 0;
        for (Map.Entry<Product, Integer> entry : currentOrder.getCart().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += quantity * product.getPrice();
            if (product instanceof Shippable shippableProduct) {
                shippingWeight += shippableProduct.getWeight() * quantity;
            }
        }
        shippingPrice = shippingWeight / 100;
        total = shippingPrice + subtotal;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void printReceipt() {
        computeTotal();

        System.out.println("========= RECEIPT =========");
        System.out.println(String.format(
                "%-15s %5s %12s %12s %12s",
                "Product", "Qty", "Unit Price", "Total", "Weight"
        ));

        for (Map.Entry<Product, Integer> entry : currentOrder.getCart().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            double totalPrice = quantity * product.getPrice();
            double totalWeight = 0;

            if (product instanceof Shippable shippableProduct) {
                totalWeight = shippableProduct.getWeight() * quantity;
            }

            String weightStr = String.format("%.0f g", totalWeight);

            System.out.println(String.format(
                    "%-15s %5d %12.2f %12.2f %12s",
                    product.getName(),
                    quantity,
                    product.getPrice(),
                    totalPrice,
                    weightStr
            ));
        }

        System.out.println("---------------------------");
        System.out.printf("Subtotal:           %.2f\n", subtotal);
        System.out.printf("Shipping Weight:    %.0f g\n", shippingWeight);
        System.out.printf("Shipping Cost:      %.2f\n", shippingPrice);
        System.out.printf("Total:              %.2f\n", total);
        System.out.println("===========================\n");
    }


}

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Stock {
    private final Map<Product, Integer> inventory = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product instanceof Expirable expirable) {
            if (expirable.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println("Cannot add expired product to stock: " + product.getName());
                return;
            }
        }

        inventory.merge(product, quantity, Integer::sum);
    }

    public void removeProduct(Product product, int quantity) {
        Integer currentQty = inventory.get(product);
        int newQty = currentQty - quantity;
        if (newQty > 0) {
            inventory.put(product, newQty);
        } else {
            inventory.remove(product);
        }
    }

    public boolean isAvailable(Product product, int requiredQuantity) {
        return inventory.getOrDefault(product, 0) >= requiredQuantity;
    }

    public int getQuantity(Product product) {
        return inventory.getOrDefault(product, 0);
    }

    @Override
    public String toString() {
        return inventory.toString();
    }
}

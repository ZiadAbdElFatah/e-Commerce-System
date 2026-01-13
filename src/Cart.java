import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Cart {
    private final Map<Product, Integer> cart = new HashMap<>();
    private final Stock stock;

    public Cart(Stock stock) {
        this.stock = stock;
    }

    public void addProduct(Product product, int quantity) {
        if (product instanceof Expirable expirable) {
            if (expirable.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println("Cannot add expired product to cart: " + product.getName());
                return;
            }
        }

        if (!stock.isAvailable(product, quantity)) {
            System.out.println("Not enough stock for: " + product.getName());
            return;
        }

        cart.merge(product, quantity, Integer::sum);
        stock.removeProduct(product, quantity);
    }

    public void removeProduct(Product product) {
        Integer currentQty = cart.get(product);
        if (currentQty != null) {
            int newQty = currentQty - 1;
            if (newQty > 0) {
                cart.put(product, newQty);
            } else {
                cart.remove(product);
            }
            stock.addProduct(product, 1);
        }
    }

    public void removeProduct(Product product, int quantity) {
        Integer currentQty = cart.get(product);
        if (currentQty != null) {
            int removedQty = Math.min(quantity, currentQty);
            int newQty = currentQty - removedQty;
            if (newQty > 0) {
                cart.put(product, newQty);
            } else {
                cart.remove(product);
            }
            stock.addProduct(product, removedQty);
        }
    }

    public Map<Product, Integer> getCart() {
        return Map.copyOf(cart);
    }

    @Override
    public String toString() {
        return cart.toString();
    }
}

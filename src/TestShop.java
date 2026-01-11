import java.time.LocalDate;

public class TestShop {
    public static void main(String[] args) {
        Stock stock = new Stock();

        // Create products
        Cheese cheeseFresh = new Cheese(LocalDate.now().plusDays(5));
        Cheese cheeseExpired = new Cheese(LocalDate.now().minusDays(1));
        Biscuits biscuits = new Biscuits(LocalDate.now().plusDays(10));
        Mobile mobile = new Mobile();
        ScratchCard scratchCard = new ScratchCard();

        // Add products to stock
        stock.addProduct(cheeseFresh, 5);
        stock.addProduct(cheeseExpired, 5);  // should print warning
        stock.addProduct(biscuits, 10);
        stock.addProduct(mobile, 3);
        stock.addProduct(scratchCard, 7);

        System.out.println("Initial stock: " + stock);

        // Create cart
        Cart cart = new Cart();

        // Add products to cart
        cart.addProduct(cheeseFresh, 2);  // ok
        cart.addProduct(cheeseExpired, 1); // should print warning
        cart.addProduct(biscuits, 5);
        cart.addProduct(mobile, 1);
        cart.addProduct(scratchCard, 3);

        System.out.println("Cart after adding: " + cart);
        System.out.println("Stock after adding to cart: " + stock);

        // Remove products from cart
        cart.removeProduct(biscuits, 2);
        cart.removeProduct(mobile);
        System.out.println("Cart after removing: " + cart);
        System.out.println("Stock after removing from cart: " + stock);

        Order order = new Order(cart);
        order.printReceipt();
    }
}

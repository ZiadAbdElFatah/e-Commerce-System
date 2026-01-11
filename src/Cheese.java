import java.time.LocalDate;

public class Cheese extends Food {
    Cheese(LocalDate expiryDate) {
        setName("Cheese");
        setPrice(20);
        setWeight(250);
        setExpiryDate(expiryDate);
    }
}

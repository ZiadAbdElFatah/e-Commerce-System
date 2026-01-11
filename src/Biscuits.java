import java.time.LocalDate;

public class Biscuits extends Food {
    Biscuits(LocalDate expiryDate) {
        setName("Biscuits");
        setPrice(10);
        setWeight(100);
        setExpiryDate(expiryDate);
    }
}

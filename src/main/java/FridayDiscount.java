import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    public boolean isApplicable(Product product) {
        LocalDate today = LocalDate.now();
        return today.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    public double calculateDiscount(Product product) {
        if (isApplicable(product)) {
            double discount = 10.0 / 100.0;
            return product.Price() * discount;

        }
        return 0;
    }

    @Override
    public int apply(Product product) {

        return 1;

    }

    @Override
    public String getDescription(Product product) {
        return "Discount friday";
    }
}
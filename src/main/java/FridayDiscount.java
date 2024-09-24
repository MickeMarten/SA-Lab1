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
        double discount = 0;
        if (isApplicable(product)) {
            discount = product.Price() * 0.10;


        }
        if(nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }

        return discount;
    }

    @Override
    public double apply(Product product) {
        return calculateDiscount(product);

    }

    @Override
    public String getDescription(Product product) {
        String description = "";
        if(isApplicable(product)) {
            description = "Friday discount 10%." + " ";
        }
        if (nextDiscount != null) {
            description += nextDiscount.getDescription(product);
        }


        return description;
    }
}
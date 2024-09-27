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

        return discount;
    }


    @Override
    public String getDescription(Product product) {
        String description = "";
        if(isApplicable(product)) {
            description = "Friday discount 10%." + " ";
        }



        return description + (nextDiscount != null ? nextDiscount.getDescription(product) : "");
    }
}
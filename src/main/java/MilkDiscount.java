
public class MilkDiscount extends BaseDiscount {
    MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.name().equals("Milk");

    }

    @Override
    public double calculateDiscount(Product product) {
        if (isApplicable(product)) {
            double discount = 5.0 / 100.0;
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
        return "5% discount on milk!";
    }
}
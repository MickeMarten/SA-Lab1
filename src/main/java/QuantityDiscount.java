public class QuantityDiscount extends BaseDiscount {

    QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.Quantity() > 5;
    }

    @Override
    public double calculateDiscount(Product product) {
        int totalPrize = product.Price() * product.Quantity();
        if (isApplicable(product)) {
            return totalPrize - 10 * product.Quantity();

        }
        return 0;
    }

    @Override
    public int apply(Product product) {
        return 1;

    }

    @Override
    public String getDescription(Product product) {
        return "10kr discount if you buy atleast 5!";
    }
}
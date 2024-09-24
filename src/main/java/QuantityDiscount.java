public class QuantityDiscount extends BaseDiscount {

    QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.Quantity() >= 5;
    }

    @Override
    public double calculateDiscount(Product product) {
        double discount = 0;
        if (isApplicable(product)) {
            discount = 10 * product.Quantity();

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
            description = "-10 on every product if you buy more than 5." + " ";
        }
        if (nextDiscount != null) {
            description +=  nextDiscount.getDescription(product);
        }

        return description;
    }
}
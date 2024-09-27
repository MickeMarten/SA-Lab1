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


        return discount;
    }


    @Override
    public String getDescription(Product product) {
        String description = "";
        if(isApplicable(product)) {
            description = "-10kr on every product if you buy more than 5." + " ";
        }


        return description + (nextDiscount != null ? nextDiscount.getDescription(product) : "");
    }
}
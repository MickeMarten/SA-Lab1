
public class MilkDiscount extends BaseDiscount {
    MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equals("Milk");

    }

    @Override
    protected double calculateDiscount(Product product) {
        double discount = 0;
        if (isApplicable(product)) {
            discount = product.Price() * 0.05;
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
            description = "5% discount on milk." + " ";
        }
        if (nextDiscount != null) {
            description +=  nextDiscount.getDescription(product);
        }

        return description;
    }
}
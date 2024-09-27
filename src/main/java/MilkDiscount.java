
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


        return discount;
    }


    @Override
    public String getDescription(Product product) {
        String description = "";
        if(isApplicable(product)) {
            description = "5% discount on milk." + " ";
        }


        return description + (nextDiscount != null ? nextDiscount.getDescription(product) : "");
    }
}
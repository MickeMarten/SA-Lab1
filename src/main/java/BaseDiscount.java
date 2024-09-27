abstract class BaseDiscount implements Discount {

    public final Discount nextDiscount;

    BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        double discount = 0.0;
        if(isApplicable(product)) {
        discount = calculateDiscount(product);
        }
        if(nextDiscount != null){
            discount += nextDiscount.apply(product);

        }
            return discount;
    };


    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);
}
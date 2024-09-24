abstract class BaseDiscount implements Discount {

    Discount nextDiscount;

    BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }


    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);
}
public class NoDiscount extends BaseDiscount {

    NoDiscount() {
        super(null);
    }

    @Override
    public boolean isApplicable(Product product) {
        return false;

    }

    @Override
    public double calculateDiscount(Product product) {
    return 0.0;
    }


    @Override
    public String getDescription(Product product) {
       return "";

    }

}

public class Main {
    public static void main(String[] args) {
        Product test = new Product("Milk", 20, 5);
        Product test2 = new Product("Milk", 150, 11);

        Discount discounts = new FridayDiscount( new MilkDiscount( new QuantityDiscount(null)));

        System.out.println(discounts.apply(test) + " " + discounts.getDescription(test));




    }


}



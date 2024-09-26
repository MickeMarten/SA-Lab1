public class Main {
    public static void main(String[] args) {
        Product test = new Product("Milk", 20, 5);
        Product test2 = new Product("Köttbullar", 55, 7);

        Discount discounts = new FridayDiscount( new MilkDiscount( new QuantityDiscount(null)));
        Discount discounts2 = new FridayDiscount( new MilkDiscount( new QuantityDiscount(null)));

        System.out.println(discounts.apply(test) + ": " + discounts.getDescription(test));
        System.out.println(discounts2.apply(test2) + ": " + discounts2.getDescription(test2));



    }


}



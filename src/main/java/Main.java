public class Main {
    public static void main(String[] args) {
        Product test = new Product("Milk", 20, 1);
        Product test2 = new Product("Köttbullar", 20, 1);

        Discount discounts = new FridayDiscount( new MilkDiscount( new QuantityDiscount(new NoDiscount())));
        Discount discounts2 = new FridayDiscount( new MilkDiscount( new QuantityDiscount(new NoDiscount())));

        System.out.println(discounts.apply(test) + ": " + discounts.getDescription(test));
        System.out.println(discounts2.apply(test2) + ": " + discounts2.getDescription(test2));



    }


}



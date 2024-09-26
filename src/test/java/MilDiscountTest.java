import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class MilDiscountTest {

    private static MilkDiscount milkDiscount;
    private static Discount nextDiscount;
    @BeforeAll
    static void setup() {
        milkDiscount = new MilkDiscount(null);
    }

    @Test
    @DisplayName("Test to check that isApplicable is false if name is not milk")
    void testToCheckDiscountIsNotApplicableIfNameIsNotMilk(){
        var newProduct = new Product("Mölk", 20, 1);
        assertThat(milkDiscount.isApplicable(newProduct)).isFalse();

    }

    @Test
    @DisplayName("Test to check that discount is 0 if name is not Milk")

    void testToCheckDiscountIsZeroIfNameIsNotMilk(){
        var newProduct = new Product("Mölk", 20, 1);
        assertThat(milkDiscount.calculateDiscount(newProduct)).isEqualTo(0.0);


    }

    @Test
    @DisplayName("Test for calculating Milk discount")

    void testToCalculateMilkDiscount(){
        var newProduct = new Product("Milk", 20, 1);
        assertThat(milkDiscount.calculateDiscount(newProduct)).isEqualTo(1.0);

    }



    @Test
    @DisplayName("Test to check discount chaining")
    void testDiscountsAreChainedCorrectlyOnSameProduct(){
        var discountChain = new MilkDiscount(new QuantityDiscount(null));
        Product newProduct = new Product("Milk", 20, 10);

        double totalDiscount = discountChain.apply(newProduct);
        double expectedMilkDiscount = newProduct.Price() * 0.05;
        double expectedQuantityDiscount =  10 * newProduct.Quantity();

        assertThat(totalDiscount).isEqualTo(expectedMilkDiscount + expectedQuantityDiscount);




    }




}

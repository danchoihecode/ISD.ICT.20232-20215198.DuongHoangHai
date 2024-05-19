package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import placeorder.Cart;
import placeorder.PlaceOrderController;
import placeorder.Product;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlaceOrderControllerTest {

    PlaceOrderController controller = new PlaceOrderController();

        public Stream<Arguments> testCases() {
            Product p1 = new Product("Jungle", 20, 10000, 1.2, true);
            Product p2 = new Product("Tom Cat", 10, 15000, 1.5, true);

            Cart cart1 = new Cart();
            cart1.addProduct(p1, 3); // 3.6 kg
            cart1.addProduct(p2, 2); // 3.0 kg


            Cart cart2 = new Cart();
            cart2.addProduct(p1, 1); // 1.2 kg
            cart2.addProduct(p2, 1); // 1.5 kg

            Cart cart3 = new Cart();
            cart3.addProduct(p1, 5); // 6.0 kg
            cart3.addProduct(p2, 1); // 1.5 kg

            return Stream.of(
                Arguments.of(cart1, "Hanoi", 27000), 
                Arguments.of(cart1, "Da Nang", 47500),
                Arguments.of(cart2, "Ho Chi Minh City", 22000),
                Arguments.of(cart2, "Hai Phong", 35000),
                Arguments.of(cart3, "Hanoi", 37000),
                Arguments.of(cart3, "Da Nang", 57500)
            );
        }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCalculateShippingFee(Cart cart, String province, double expected) {
        controller.placeOrder(cart); 
        double actual = controller.calculateShippingFee(province);
        assertEquals(expected, actual);
    }
}
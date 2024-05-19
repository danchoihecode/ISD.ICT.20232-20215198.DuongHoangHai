package test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import placeorder.Cart;
import placeorder.Product;

public class CartTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void testCheckProductAvailability(Cart cart, boolean expected) {
        boolean actual = cart.checkProductAvailability();
        Assertions.assertEquals(expected, actual);
    }
 
    static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(createCart(new Object[][] {
                {"Jungle", 20, 10000,1.2, true, 21},
                {"Tom Cat", 10, 20000,1.3, true, 5}
            }), false),
            Arguments.of(createCart(new Object[][] {
                {"Jungle", 20, 10000,1.2, true, 10},
                {"Tom Cat", 10, 20000,1.3, true, 11}
            }), false),
            Arguments.of(createCart(new Object[][] {
                {"Jungle", 20, 10000,1.2, true, 20},
                {"Tom Cat", 10, 20000,1.3, true, 10},
                {"Adventure", 5, 15000,2.1, false, 3}
            }), true)
        );
    }

    private static Cart createCart(Object[][] products) {
        Cart cart = new Cart();
        for (Object[] productInfo : products) {
            String title = (String) productInfo[0];
            int quantityInStock = (int) productInfo[1];
            int price = (int) productInfo[2];
            double weight = (double) productInfo[3];
            boolean rushOrderEligible = (boolean) productInfo[4];
            int quantityInCart = (int) productInfo[5];
            Product product = new Product(title, quantityInStock, price, weight, rushOrderEligible);
            cart.addProduct(product, quantityInCart);
        }
        return cart;
    }
}

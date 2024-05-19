package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import placeorder.DeliveryInfo;

class DeliveryInfoTest {

    DeliveryInfo info;

    @ParameterizedTest
    @CsvSource({
        "Duong Hoang Hai, 0123456789, abc@gmail.com, Thanh Xuan, Hanoi, true",
        "John Doe, 0987654321, jdoe@example.com, Wall Street, New York, false" 
    })
    void testCheckAddessSupportability(String name, String phone, String email, String address, String province,
                                       boolean expected) {
        info = new DeliveryInfo(name, phone, email, address, province);
        boolean actual = info.checkAddessSupportability();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "Duong Hoang Hai, 0123456789, abc@gmail.com, Thanh Xuan, Hanoi, true",
        "Alice Johnson, 1234567890, ab c@example.com, Central, Sydney, false", // Email has a space
        "Bob Brown, 12345678, brown@example.com, Downtown, Chicago, false", // Phone number has less than 10 digits
        "Carol White, 09876543210, white@example.com, Midtown, Atlanta, false" // Phone number has more than 10 digits
    })
    void testValidateDeliveryInfo(String name, String phone, String email, String address, String province,
                                  boolean expected) {
        info = new DeliveryInfo(name, phone, email, address, province);
        boolean actual = info.validateDeliveryInfo();
        assertEquals(expected, actual);
    }
}
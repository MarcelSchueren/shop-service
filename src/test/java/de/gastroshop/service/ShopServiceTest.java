package de.gastroshop.service;

import de.gastroshop.model.Beer;
import de.gastroshop.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void getProductTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        //WHEN
        Product actual = shopService.getProduct(1);
        Product expected = new Beer("Edelpils", "Pils", 1, 0.49);
        //THEN
        assertEquals(expected, actual);
    }
}
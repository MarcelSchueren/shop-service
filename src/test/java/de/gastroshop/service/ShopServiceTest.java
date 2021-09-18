package de.gastroshop.service;

import de.gastroshop.model.Beer;
import de.gastroshop.model.Liquor;
import de.gastroshop.model.Order;
import de.gastroshop.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void getProductTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        //WHEN
        Product actual;
        if (shopService.getProduct(1).isPresent()) {
            actual = shopService.getProduct(1).get();
        } else {
            actual = null;
        }
        Product expected = new Beer("Edelpils", "Pils", 1, 0.49);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void listProductsTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        //WHEN
        String actual = shopService.listProducts();
        String expected =   "Product ID: 1 Beer: Edelpils, Pils, 0.49 Euro\n" +
                            "Product ID: 2 Beer: Düsseldorfer, Alt, 0.59 Euro\n" +
                            "Product ID: 3 Liquor: Whiskey, 40, 19.99 Euro\n" +
                            "Product ID: 4 Liquor: Gin, 40, 29.99 Euro\n";
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        Product beer = new Beer("Edelpils", "Pils", 1, 0.49);
        Product liquor = new Liquor("Whiskey", 3, 40, 19.99);
        shopService.addOrder(beer, liquor);
        //WHEN
        Optional<Order> actual = shopService.getOrder(1);
        Optional<Order> expected = Optional.of(new Order(1, beer, liquor));
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void listOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        Product beer = new Beer("Edelpils", "Pils", 1, 0.49);
        Product liquor = new Liquor("Whiskey", 3, 40, 19.99);
        shopService.addOrder(beer);
        shopService.addOrder(liquor);
        //WHEN
        String actual = shopService.listOrder();
        String expected =   "Order ID: 1\n" +
                            "Product ID: 1 Beer: Edelpils, Pils, 0.49 Euro\n" +
                            "\n" +
                            "Order ID: 2\n" +
                            "Product ID: 3 Liquor: Whiskey, 40, 19.99 Euro\n\n";
        //THEN
        assertEquals(expected, actual);
    }
}
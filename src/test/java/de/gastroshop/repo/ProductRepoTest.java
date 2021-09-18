package de.gastroshop.repo;

import de.gastroshop.model.Beer;
import de.gastroshop.model.Liquor;
import de.gastroshop.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void productRepoListTest() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        Beer pils = new Beer("Edelpils", "Pils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", "Alt", 2, 0.59);
        Liquor whiskey = new Liquor("Whiskey", 3, 40, 19.99);
        Liquor gin = new Liquor("Gin", 4, 40, 29.99);

        List<Product> expected = new ArrayList<>();
        expected.add(pils);
        expected.add(alt);
        expected.add(whiskey);
        expected.add(gin);
        //WHEN
        List<Product> actual = productRepo.list();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void productRepoGetTest_ExpectedOptionalOf() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        Liquor whiskey = new Liquor("Whiskey", 3, 40, 19.99);
        //WHEN
        Optional<Product> actual = productRepo.get(3);
        Optional<Product> expected = Optional.of(whiskey);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void productRepoGetTest_ExpectedOptionalEmpty() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        //WHEN
        Optional<Product> actual = productRepo.get(50);
        Optional<Product> expected = Optional.empty();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void productRepoToStringTest() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        //WHEN
        String actual = productRepo.toString();
        String expected =   "Product ID: 1 Beer: Edelpils, Pils, 0.49 Euro\n" +
                            "Product ID: 2 Beer: Düsseldorfer, Alt, 0.59 Euro\n" +
                            "Product ID: 3 Liquor: Whiskey, 40, 19.99 Euro\n" +
                            "Product ID: 4 Liquor: Gin, 40, 29.99 Euro\n";
        //THEN
        assertEquals(expected, actual);
    }
}
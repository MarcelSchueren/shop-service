package de.gastroshop.repo;

import de.gastroshop.model.Beer;
import de.gastroshop.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void orderRepoAddAndListTest() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Beer pils = new Beer("Edelpils", "Pils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", "Alt", 2, 0.59);
        Order order1 = new Order(1, pils, alt);
        Order order2 = new Order(2, alt, pils);
        orderRepo.add(order1);
        orderRepo.add(order2);
        //WHEN
        List<Order> actual = orderRepo.list();
        List<Order> expected = List.of(order1, order2);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void orderRepoGetTest() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Beer pils = new Beer("Edelpils", "Pils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", "Alt", 2, 0.59);
        Order order1 = new Order(1, pils, alt);
        Order order2 = new Order(2, alt, pils);
        orderRepo.add(order1);
        orderRepo.add(order2);
        //WHEN
        Optional<Order> actual = orderRepo.get(2);
        Optional<Order> expected = Optional.of(order2);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void orderRepoToStringTest() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Beer pils = new Beer("Edelpils", "Pils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", "Alt", 2, 0.59);
        Order order1 = new Order(1, pils, alt);
        Order order2 = new Order(2, alt, pils);
        orderRepo.add(order1);
        orderRepo.add(order2);
        //WHEN
        String actual = orderRepo.toString();
        String expected = "Order ID: 1\n" +
                "Product ID: 1 Beer: Edelpils, Pils, 0.49 Euro\n" +
                "Product ID: 2 Beer: Düsseldorfer, Alt, 0.59 Euro\n" +
                "\n" +
                "Order ID: 2\n" +
                "Product ID: 2 Beer: Düsseldorfer, Alt, 0.59 Euro\n" +
                "Product ID: 1 Beer: Edelpils, Pils, 0.49 Euro\n" +
                "\n";
        //THEN
        assertEquals(expected, actual);
    }
}
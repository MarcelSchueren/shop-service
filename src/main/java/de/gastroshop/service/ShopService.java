package de.gastroshop.service;

import de.gastroshop.model.Order;
import de.gastroshop.model.Product;
import de.gastroshop.repo.OrderRepo;
import de.gastroshop.repo.ProductRepo;

import java.util.List;

public class ShopService {

    ProductRepo productRepo = new ProductRepo();
    OrderRepo orderRepo = new OrderRepo();
    int idForOrders = 1;

    public Product getProduct(int id) {
        return productRepo.get(id);
    }

    public String listProducts() {
        return productRepo.toString();
    }

    public Order getOrder(int id) {
        return orderRepo.get(id);
    }

    public String listOrder() {
        return orderRepo.toString();
    }

    public void addOrder(Product... products) {
        Order order = new Order(idForOrders, products);
        orderRepo.add(order);
        idForOrders++;
    }

    public void addOrder(List<Product> products) {
        Order order = new Order(idForOrders, products);
        orderRepo.add(order);
        idForOrders++;
    }

}

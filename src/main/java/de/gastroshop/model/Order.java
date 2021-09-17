package de.gastroshop.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products = new ArrayList<>();

    public Order(int id, Product ... products) {
        this.id = id;
        this.products.addAll(Arrays.asList(products));
    }

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products.addAll(products);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: " + id + "\n");
        for (Product product : products) {
            sb.append(product);
        }
    return sb.toString();
    }

}

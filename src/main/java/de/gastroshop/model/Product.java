package de.gastroshop.model;

public interface Product {

    String getName();
    int getId();
    double getPrice();

    void setName(String name);
    void setId(int id);
    void setPrice(double price);

}


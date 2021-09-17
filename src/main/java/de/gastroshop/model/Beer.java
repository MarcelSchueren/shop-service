package de.gastroshop.model;

public class Beer implements Product {

    String name;
    String type;
    int id;
    double price;

    public Beer(String name, String type, int id, double price) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + " Beer: " + name + ", " + type + ", " + price + " Euro\n";
    }
}

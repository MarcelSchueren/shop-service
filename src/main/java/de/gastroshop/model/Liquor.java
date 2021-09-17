package de.gastroshop.model;

public class Liquor implements Product{

    String name;
    int id;
    int alcoholContent;
    double price;

    public Liquor(String name, int id, int alcoholContent, double price) {
        this.name = name;
        this.id = id;
        this.alcoholContent = alcoholContent;
        this.price = price;
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

    public int getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(int alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        return "Product ID: "+  id + " Liquor: " + name + ", " + alcoholContent + ", " + price + " Euro\n";
    }
}

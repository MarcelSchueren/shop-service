package de.gastroshop.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liquor liquor = (Liquor) o;
        return id == liquor.id && alcoholContent == liquor.alcoholContent && Double.compare(liquor.price, price) == 0 && Objects.equals(name, liquor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, alcoholContent, price);
    }
}

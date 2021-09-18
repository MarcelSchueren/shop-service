package de.gastroshop.repo;

import de.gastroshop.model.Beer;
import de.gastroshop.model.Liquor;
import de.gastroshop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private List<Product> availableProducts = new ArrayList<>();

    public ProductRepo() {
        generateAvailableProducts();
    }

    private void generateAvailableProducts() {
        Beer pils = new Beer("Edelpils", "Pils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", "Alt", 2, 0.59);
        Liquor whiskey = new Liquor("Whiskey", 3, 40, 19.99);
        Liquor gin = new Liquor("Gin", 4, 40, 29.99);

        availableProducts.add(pils);
        availableProducts.add(alt);
        availableProducts.add(whiskey);
        availableProducts.add(gin);
    }

    public List<Product> list() {
        return this.availableProducts;
    }

    public Optional<Product> get(int id) {
        for (Product product : availableProducts) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product availableProduct : availableProducts) {
            sb.append(availableProduct.toString());
        }
        return sb.toString();
    }
}

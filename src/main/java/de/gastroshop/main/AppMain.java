package de.gastroshop.main;

import de.gastroshop.model.Product;
import de.gastroshop.service.ShopService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMain {
    @SuppressWarnings("OptionalGetWithoutIsPresent") //vgl Z. 72f
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        System.out.println("\nWillkommen im GastroShop :)\n");

        while (true) {
            System.out.println("\nMenü:\n");
            System.out.println("Produktliste aufrufen - 1");
            System.out.println("Orderliste aufrufen   - 2");
            System.out.println("Produkt anzeigen      - 3");
            System.out.println("Order anzeigen        - 4");
            System.out.println("Order anlegen         - 5");
            System.out.println("Programm beenden      - 6\n");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Bitte nur Zahlen eingeben!");
            }
            switch (choice) {
                case 1:
                    System.out.println(shopService.listProducts());
                    break;
                case 2:
                    System.out.println(shopService.listOrder());
                    break;
                case 3:
                    System.out.println("Bitte Produkt-Id angeben: ");

                    try {
                        int id = scanner.nextInt();
                        if (!shopService.getProduct(id).isPresent()) {
                            throw new IllegalArgumentException("Falsche Produkt-ID!");
                        }
                        System.out.println(shopService.getProduct(id));
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.err.println("Bitte korrekte Produkt-ID eingeben!");
                    }
                    break;
                case 4:
                    System.out.println("Bitte Order-Id eingeben: ");
                    try {
                        int orderId = scanner.nextInt();
                        if (!shopService.getOrder(orderId).isPresent()) {
                            throw new IllegalArgumentException("Falsche Order-ID!");
                        }
                        System.out.println(shopService.getOrder(orderId).get());
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.err.println("Bitte korrekte Order-ID eingeben!");

                    }
                    break;
                case 5:
                    ArrayList<Product> orders = new ArrayList<>();
                    int productId;
                    do {
                        System.out.println("Bitte Produkt-Id eingeben: (0 wenn Bestellung abgeschlossen) ");
                        productId = scanner.nextInt();
                        if (checkIfProductIdIsValid(productId, shopService)) {
                            //Check des Optional erfolgt in darüberliegender Zeile
                            orders.add(shopService.getProduct(productId).get());
                        } else {
                            if (productId != 0) {
                                System.out.println("Fehlerhafte ID!");
                            }
                        }
                    }
                    while (productId != 0);
                    shopService.addOrder(orders);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Fehlerhafte Auswahl!");
                    break;
            }
        }
    }

    private static boolean checkIfProductIdIsValid(int productId, ShopService shopService) {
        return productId >= 0 && shopService.getProduct(productId).isPresent();
    }
}

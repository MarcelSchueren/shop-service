package de.gastroshop.main;

import de.gastroshop.model.Product;
import de.gastroshop.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        System.out.println("\nWillkommen im GastroShop :)\n");

        while (true){
            System.out.println("\nMenü:\n");
            System.out.println("Produktliste aufrufen - 1");
            System.out.println("Orderliste aufrufen - 2");
            System.out.println("Produkt anzeigen - 3");
            System.out.println("Order anzeigen -4" );
            System.out.println("Order anlegen -5");
            System.out.println("Programm beenden -6\n");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(shopService.listProducts());
                    break;
                case 2:
                    System.out.println(shopService.listOrder());
                    break;
                case 3:
                    System.out.println("Bitte Produkt-Id angeben: ");
                    int id = scanner.nextInt();
                    System.out.println(shopService.getProduct(id));
                    break;
                case 4:
                    System.out.println("Bitte Order-Id eingeben: ");
                    int orderId = scanner.nextInt();
                    System.out.println(shopService.getOrder(orderId));
                    break;
                case 5:
                    ArrayList<Product> orders = new ArrayList<>();
                    int productId;
                    do {
                        System.out.println("Bitte Product-Id eingeben: (0 wenn Bestellung abgeschlossen) ");
                        productId = scanner.nextInt();
                        orders.add(shopService.getProduct(productId));
                    }
                    while (productId != 0);
                    shopService.addOrder(orders);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}

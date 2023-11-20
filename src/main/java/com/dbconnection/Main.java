package com.dbconnection;

import java.util.Scanner;

import com.dbconnection.dao.ProductDaoIimplem;
import com.dbconnection.dao.Entities.Product;
import com.dbconnection.utils.RandomIntGenerator;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        ProductDaoIimplem productDaoIimplem = new ProductDaoIimplem();

        while (choice != 5) {
            System.out.println("1- add a product");
            System.out.println("2- remove a product");
            System.out.println("3- update a product");
            System.out.println("4- search a product");
            System.out.println("5- exit");
            System.out.println("choose a number between 1, 2, 3, 4 or 5");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // get the product from the user
                    System.out.println("enter the name");
                    String name = scanner.next();
                    System.out.println("enter the description");
                    String description = scanner.next();
                    System.out.println("enter the price");
                    int price = scanner.nextInt();
                    System.out.println("enter the quantity");
                    int quantity = scanner.nextInt();

                    Product product = new Product(RandomIntGenerator.generateRandomInt(), name, description, price,
                            quantity);

                    productDaoIimplem = new ProductDaoIimplem();
                    productDaoIimplem
                            .save(product);
                    break;
                case 2:
                    System.out.println("enter the id of the product you want to remove");
                    int id = scanner.nextInt();
                    productDaoIimplem = new ProductDaoIimplem();
                    productDaoIimplem.removeById(id);
                    break;
                case 3:
                    System.out.println("this is the update");
                    break;
                case 4:
                    System.out.println("this is the search");
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("choose a valid number");
                    break;
            }

        }

        scanner.close();
    }
}
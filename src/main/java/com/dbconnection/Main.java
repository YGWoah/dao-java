package com.dbconnection;

import java.util.Scanner;

import com.dbconnection.dao.Entities.Client;
import com.dbconnection.dao.Entities.Product;
import com.dbconnection.dao.client.ClientDaoImp;
import com.dbconnection.dao.product.ProductDaoImp;
import com.dbconnection.utils.RandomIntGenerator;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mainChoice = 0;

        while (mainChoice != 3) {
            System.out.println("Main Menu:");
            System.out.println("1- Product Menu");
            System.out.println("2- Client Menu");
            System.out.println("3- Exit");
            System.out.println("Choose a number between 1, 2, or 3");

            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    productMenu();
                    break;
                case 2:
                    clientMenu();
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Choose a valid number");
                    break;
            }
        }

        scanner.close();

    }

    private static void clientMenu() {
        Scanner scanner = new Scanner(System.in);
        int clientChoice = 0;
        ClientDaoImp clientDaoImp = new ClientDaoImp();

        while (clientChoice != 5) {
            System.out.println("Client Menu:");
            System.out.println("1- Add a client");
            System.out.println("2- Remove a client");
            System.out.println("3- Update a client");
            System.out.println("4- Search a client by ID");
            System.out.println("5- Back to Main Menu");
            System.out.println("Choose a number between 1, 2, 3, 4, or 5");

            clientChoice = scanner.nextInt();

            switch (clientChoice) {
                case 1:
                    // get the client from the user
                    System.out.println("enter the name");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.println("enter the last name");
                    String lastName = scanner.nextLine();
                    System.out.println("enter the email");
                    String email = scanner.nextLine();
                    System.out.println("enter the address");
                    String address = scanner.nextLine();
                    System.out.println("enter the password");
                    String password = scanner.nextLine();

                    Client client = new Client(RandomIntGenerator.generateRandomInt(), name, lastName, email, address,
                            password);

                    clientDaoImp = new ClientDaoImp();
                    clientDaoImp.save(client);
                    break;
                case 2:
                    System.out.println("enter the id of the client you want to remove");
                    int id = scanner.nextInt();
                    clientDaoImp = new ClientDaoImp();
                    clientDaoImp.removeById(id);
                    System.out.println("Client removed successfully");
                    break;
                case 3:
                    System.out.println("this is the update");
                    break;
                case 4:
                    System.out.println("this is the search");
                    System.out.println("enter the id of the client you want to search");
                    id = scanner.nextInt();

                    Client client2 = clientDaoImp.findById(id);
                    if (client2 == null) {
                        System.out.println("the client with the id " + id + " does not exist");
                        break;
                    } else
                        System.out.println("no client with the id " + id + " was found");
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Choose a valid number");
                    break;
            }
        }

        scanner.close();

    }

    private static void productMenu() {
        Scanner scanner = new Scanner(System.in);
        int productChoice = 0;
        ProductDaoImp productDaoIimplem = new ProductDaoImp();

        while (productChoice != 6) {
            System.out.println("Product Menu:");
            System.out.println("1- Add a product");
            System.out.println("2- Remove a product");
            System.out.println("3- Update a product");
            System.out.println("4- Search a product by ID");
            System.out.println("5- Search a product by name");
            System.out.println("6- Back to Main Menu");
            System.out.println("Choose a number between 1, 2, 3, 4, 5, or 6");

            productChoice = scanner.nextInt();

            switch (productChoice) {
                case 1:
                    // get the product from the user
                    System.out.println("enter the name");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.println("enter the description");
                    String description = scanner.nextLine();
                    System.out.println("enter the price");
                    int price = scanner.nextInt();
                    System.out.println("enter the quantity");
                    int quantity = scanner.nextInt();

                    Product product = new Product(RandomIntGenerator.generateRandomInt(), name, description, price,
                            quantity);

                    productDaoIimplem = new ProductDaoImp();
                    productDaoIimplem.save(product);
                    break;
                case 2:
                    System.out.println("enter the id of the product you want to remove");
                    int id = scanner.nextInt();
                    productDaoIimplem = new ProductDaoImp();
                    productDaoIimplem.removeById(id);
                    break;
                case 3:
                    System.out.println("this is the update");
                    break;
                case 4:
                    System.out.println("this is the search");
                    System.out.println("enter the id of the product you want to search");
                    id = scanner.nextInt();

                    Product product2 = productDaoIimplem.findById(id);
                    if (product2 == null) {
                        System.out.println("the product with the id " + id + " does not exist");
                        break;
                    } else
                        System.out.println("no product with the id " + id + " was found");
                    break;
                case 5:
                    System.out.println("search by name");
                    System.out.println("enter the name of the product you want to search");
                    scanner.nextLine(); // Consume the newline character
                    String name2 = scanner.nextLine();
                    productDaoIimplem = new ProductDaoImp();
                    Product product3 = productDaoIimplem.searchByname(name2);
                    if (product3 == null) {
                        System.out.println("the product with the name " + name2 + " does not exist");
                    } else {
                        System.out.println("no product with the name " + name2 + " was found");
                    }
                    break;
                case 6:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("choose a valid number");
                    break;
            }

        }
    }
}
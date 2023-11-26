package com.dbconnection.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.dao.DBSingleton;
import com.dbconnection.dao.Entities.Product;

/**
 * ProductDaoIimplem
 */
public class ProductDaoImp implements ProductDao {

    @Override
    public void save(Product t) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "INSERT INTO `product` (`id`, `nom`, `description`, `prix`, `quantite`) VALUES (?, ?, ?, ?, ?)");
            preparableStatement.setInt(1, t.getId());
            preparableStatement.setString(2, t.getNom());
            preparableStatement.setString(3, t.getDescription());
            preparableStatement.setInt(4, t.getPrix());
            preparableStatement.setInt(5, t.getQuantite());
            preparableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(Integer id) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try (PreparedStatement preparableStatement = connection
                .prepareStatement("DELETE FROM `product` WHERE `product`.`id` = ?")) {
            preparableStatement.setInt(1, id);
            preparableStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product t) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "UPDATE `product` SET `nom` = ?, `description` = ?, `prix` = ?, `quantite` = ? WHERE `product`.`id` = ?");
            preparableStatement.setString(1, t.getNom());
            preparableStatement.setString(2, t.getDescription());
            preparableStatement.setInt(3, t.getPrix());
            preparableStatement.setInt(4, t.getQuantite());
            preparableStatement.setInt(5, t.getId());
            preparableStatement.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(Integer id) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection
                    .prepareStatement("SELECT * FROM `product` WHERE `product`.`id` = ?");
            preparableStatement.setInt(1, id);
            try {
                ResultSet resultSet = preparableStatement.executeQuery();
                System.out.println(resultSet);
                if (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    String productName = resultSet.getString("nom");
                    String productDescription = resultSet.getString("description");
                    int productPrice = resultSet.getInt("prix");
                    int productQuantity = resultSet.getInt("quantite");
                    return new Product(productId, productName, productDescription, productPrice, productQuantity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if no product is found
    }

    @Override
    public List<Product> findAll() {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `product`");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("nom");
                String productDescription = resultSet.getString("description");
                int productPrice = resultSet.getInt("prix");
                int productQuantity = resultSet.getInt("quantite");
                products.add(new Product(productId, productName, productDescription, productPrice, productQuantity));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product searchQuery(String query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchQuery'");
    }

    @Override
    public Product searchByname(String name) {

        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection
                    .prepareStatement("SELECT * FROM `product` WHERE `product`.`nom` = ?");
            preparableStatement.setString(1, name);
            try {
                ResultSet resultSet = preparableStatement.executeQuery();
                System.out.println(resultSet);
                if (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    String productName = resultSet.getString("nom");
                    String productDescription = resultSet.getString("description");
                    int productPrice = resultSet.getInt("prix");
                    int productQuantity = resultSet.getInt("quantite");
                    return new Product(productId, productName, productDescription, productPrice, productQuantity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if no product is found
    }

}
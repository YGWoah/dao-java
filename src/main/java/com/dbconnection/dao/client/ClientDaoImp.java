package com.dbconnection.dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.dao.DBSingleton;
import com.dbconnection.dao.Dao;

import com.dbconnection.dao.Entities.Client;

public class ClientDaoImp implements Dao<Client, Integer> {

    @Override
    public void save(Client t) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "INSERT INTO `clients` (`id`, `nom`, `prenom`, `email`, `password`, `address`) VALUES (?, ?, ?,  ?, ?, ?)");
            preparableStatement.setInt(1, t.getId());
            preparableStatement.setString(2, t.getNom());
            preparableStatement.setString(3, t.getPrenom());
            preparableStatement.setString(4, t.getEmail());
            preparableStatement.setString(5, t.getPassword());
            preparableStatement.setString(6, t.getAddress());
            preparableStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while saving client");
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(Integer id) {
        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement("DELETE FROM `clients` WHERE `id` = ?");
            preparableStatement.setInt(1, id);
            preparableStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void update(Client t) {

        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "UPDATE `clients` SET `nom` = ?, `prenom` = ?, `email` = ?, `password` = ?, `adresse` = ?, `telephone` = ? WHERE `clients`.`id` = ?");
            preparableStatement.setString(1, t.getNom());
            preparableStatement.setString(2, t.getPrenom());
            preparableStatement.setString(3, t.getEmail());
            preparableStatement.setString(4, t.getPassword());
            preparableStatement.setString(5, t.getAddress());
            preparableStatement.setInt(6, t.getId());
            preparableStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating client");
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(Integer id) {

        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        Client client = null;
        try {
            PreparedStatement preparableStatement = connection
                    .prepareStatement("SELECT * FROM `clients` WHERE `id` = ?");
            preparableStatement.setInt(1, id);
            preparableStatement.execute();
            client = new Client(
                    preparableStatement.getResultSet().getInt("id"),
                    preparableStatement.getResultSet().getString("nom"),
                    preparableStatement.getResultSet().getString("prenom"),
                    preparableStatement.getResultSet().getString("email"),
                    preparableStatement.getResultSet().getString("adresse"),
                    preparableStatement.getResultSet().getString("password")

            );
        } catch (Exception e) {
            System.out.println("Error while finding client by id");
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> findAll() {

        DBSingleton dbSingleton = DBSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();
        List<Client> clients = new ArrayList<Client>();
        try {
            PreparedStatement preparableStatement = connection.prepareStatement("SELECT * FROM `clients`");
            preparableStatement.execute();
            while (preparableStatement.getResultSet().next()) {
                clients.add(new Client(
                        preparableStatement.getResultSet().getInt("id"),
                        preparableStatement.getResultSet().getString("nom"),
                        preparableStatement.getResultSet().getString("prenom"),
                        preparableStatement.getResultSet().getString("email"),
                        preparableStatement.getResultSet().getString("adresse"),
                        preparableStatement.getResultSet().getString("password")));
            }
        } catch (Exception e) {
            System.out.println("Error while finding all clients");
            e.printStackTrace();
        }
        return clients;
    }

}

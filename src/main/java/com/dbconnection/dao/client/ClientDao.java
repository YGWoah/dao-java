package com.dbconnection.dao.client;

import com.dbconnection.dao.Dao;
import com.dbconnection.dao.Entities.Client;

public interface ClientDao extends Dao<Client, Integer> {
    Client searchQuery(String query);

    Client searchByname(String name);

}

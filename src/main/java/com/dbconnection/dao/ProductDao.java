package com.dbconnection.dao;

import com.dbconnection.dao.Entities.Product;

public interface ProductDao extends Dao<Product, Integer> {

    Product searchQuery(String query);

}
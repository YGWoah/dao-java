package com.dbconnection.dao.product;

import com.dbconnection.dao.Dao;
import com.dbconnection.dao.Entities.Product;

public interface ProductDao extends Dao<Product, Integer> {

    Product searchQuery(String query);

    Product searchByname(String name);

}
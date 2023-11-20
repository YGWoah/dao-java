package com.dbconnection.dao;

import java.util.List;

public interface Dao<T, ID> {
    void save(T t);

    void removeById(ID id);

    void update(T t);

    T findById(ID id);

    List<T> findAll();

}

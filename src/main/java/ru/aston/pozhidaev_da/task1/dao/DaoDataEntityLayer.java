package ru.aston.pozhidaev_da.task1.dao;

import java.util.List;

public interface DaoDataEntityLayer<T> {
    List<T> findAll();
    T findEntityById(int id);
    boolean delete(int id);
    boolean create(T t);
    T update(T t);
}

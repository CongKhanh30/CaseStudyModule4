package com.be.service;


import com.be.model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);
    void delete(int id);
    List<Product> getAll();
    List<Product> searchByName(String name);
    Product findById(int id);
    List<Product> findByCategory(int id);
    List<Product> findByCategoryIdSortPrice(int id, double min, double max);
    List<Product> findByShop(int id);
}

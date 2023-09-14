package com.be.service;

import com.be.model.Account;
import com.be.model.Product;
import com.be.model.ProductLike;

import java.util.List;

public interface ILikeService {
    void save(ProductLike productLike);
    void delete(int id);
    void delete(ProductLike productLike);
    List<ProductLike> getAll();
    public ProductLike findById(int id);
    public List<ProductLike> findAllByProductAndAccount(Product product , Account account);
    public ProductLike findByProductAndAccount(Product product , Account account);
    public int countByProduct(Product product);
    void deleteByProduct(Product product);
}

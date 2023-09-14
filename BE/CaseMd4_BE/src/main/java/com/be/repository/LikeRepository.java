package com.be.repository;

import com.be.model.Account;
import com.be.model.Product;
import com.be.model.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<ProductLike, Integer> {
    List<ProductLike> findAllByProductAndAccount(Product product, Account account);
    ProductLike findByProductAndAccount(Product product, Account account);
    int countByProduct(Product product);
    void deleteByProduct(Product product);
}
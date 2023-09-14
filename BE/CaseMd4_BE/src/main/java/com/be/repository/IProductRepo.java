package com.be.repository;


import com.be.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategoryId(int id);
    @Query(nativeQuery = true, value = "select * from Product where product.category_id = :idC and product.price between :min and :max")
    List<Product> findByCategoryIdSortPrice(@Param("idC") int idC, @Param("min") double min, @Param("max") double max);

    List<Product> findByShopId(int id);
    Product findById(int id);
}

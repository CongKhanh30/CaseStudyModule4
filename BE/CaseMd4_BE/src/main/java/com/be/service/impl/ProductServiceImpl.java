package com.be.service.impl;


import com.be.model.Product;
import com.be.repository.IProductRepo;
import com.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepo iProductRepo;
    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
      iProductRepo.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) iProductRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public List<Product> findByCategory(int id) {
        return iProductRepo.findByCategoryId(id);
    }

    @Override
    public List<Product> findByCategoryIdSortPrice(int id, double min, double max) {
        return iProductRepo.findByCategoryIdSortPrice(id, min, max);
    }

    @Override
    public List<Product> findByShop(int id) {
        return iProductRepo.findByShopId(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = iProductRepo.findByNameContaining(name);

        return products;
    }
}

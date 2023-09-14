package com.be.service.impl;

import com.be.model.Account;
import com.be.model.Product;
import com.be.model.ProductLike;
import com.be.repository.LikeRepository;
import com.be.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public void save(ProductLike productLike) {
        likeRepository.save(productLike);
    }

    @Override
    public void delete(int id) {
         likeRepository.deleteById(id);
    }

    @Override
    public void delete(ProductLike productLike) {
        likeRepository.delete(productLike);
    }

    @Override
    public List<ProductLike> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public ProductLike findById(int id) {
        return likeRepository.findById(id).get();
    }

    @Override
    public List<ProductLike> findAllByProductAndAccount(Product product, Account account) {
        return likeRepository.findAllByProductAndAccount(product,account);
    }

    @Override
    public ProductLike findByProductAndAccount(Product product , Account account) {
        return likeRepository.findByProductAndAccount(product , account);
    }
    @Override
    public int countByProduct(Product product) {
        return likeRepository.countByProduct(product);
    }

    @Override
    public void deleteByProduct( Product product) {
        likeRepository.deleteByProduct(product);
    }
}
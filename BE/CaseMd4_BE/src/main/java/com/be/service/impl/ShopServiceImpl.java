package com.be.service.impl;

import com.be.model.Shop;
import com.be.repository.IShopRepo;
import com.be.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    IShopRepo iShopRepo;
    @Override
    public void save(Shop shop) {
        iShopRepo.save(shop);
    }

    @Override
    public void delete(int id) {
       iShopRepo.deleteById(id);
    }

    @Override
    public List<Shop> getAll() {
        return (List<Shop>) iShopRepo.findAll();
    }

    @Override
    public Shop findByAccount_Id(int id) {
        return iShopRepo.findByAccount_Id(id);
    }

    @Override
    public Shop findById(int id) {
        return iShopRepo.findById(id).get();
    }

    @Override
    public Shop findByAccountId(int id) {
        return iShopRepo.findByAccount_Id(id);
    }
}

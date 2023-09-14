package com.be.service;


import com.be.model.Account;
import com.be.model.Shop;

import java.util.List;

public interface IShopService {
    void save(Shop shop);
    void delete(int id);
    List<Shop> getAll();
    Shop findById(int id);
    Shop findByAccountId(int id);

    Shop findByAccount_Id(int id);
}

package com.be.repository;

import com.be.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface IShopRepo extends CrudRepository<Shop, Integer> {
    Shop findByAccount_Id(int id);
}

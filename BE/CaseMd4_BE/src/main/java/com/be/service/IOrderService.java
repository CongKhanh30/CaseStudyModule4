package com.be.service;

import com.be.model.Orders;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    void save(Orders orders);
    boolean delete(int id);
    List<Orders> getAll();
    Optional<Orders> findOne(int id);
}

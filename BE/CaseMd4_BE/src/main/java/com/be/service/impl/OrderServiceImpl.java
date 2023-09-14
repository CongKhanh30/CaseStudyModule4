package com.be.service.impl;


import com.be.model.OrderDetail;
import com.be.model.Orders;
import com.be.repository.IOrderRepo;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepo iOrderRepo;


    @Override
    public void save(Orders orders) {
        iOrderRepo.save(orders);
    }

    @Override
    public boolean delete(int id) {
      iOrderRepo.deleteById(id);
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return (List<Orders>) iOrderRepo.findAll();
    }

    @Override
    public Optional<Orders> findOne(int id) {
        return iOrderRepo.findById(id);
    }
}

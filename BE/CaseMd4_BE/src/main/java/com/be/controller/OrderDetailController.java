package com.be.controller;

import com.be.model.OrderDetail;
import com.be.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order-details")
public class OrderDetailController {
    @Autowired
    public IOrderDetailService orderDetailService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findOneOrderDetail(@PathVariable int id) {
        Optional<OrderDetail> orderDetailOptional = orderDetailService.findOne(id);
        if (orderDetailOptional.isPresent()) {
            OrderDetail orderDetail = orderDetailOptional.get();
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("không có gì", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllOrderDetail() {
        List<OrderDetail> orderDetails = orderDetailService.getAll();
        if (!orderDetails.isEmpty()) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No order details found", HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable int id,
                                               @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> billOptional = orderDetailService.findOne(id);
        if (billOptional.isPresent()) {
            orderDetail.setId(id);
            orderDetailService.save(orderDetail);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/placeOrderDetail")
    public ResponseEntity<?> placeOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail savedOrderDetail = orderDetailService.placeOrderDetail(orderDetail);
            return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi khi tạo chi tiết đơn hàng: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable int id){
        Optional<OrderDetail> orderDetailOptional = orderDetailService.findOne(id);
        if (orderDetailOptional.isPresent()){
            orderDetailService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
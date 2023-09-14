package com.be.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AllBillOfShop {
    private String name;
    private int idorder;
    private String nameproduct;
    private int orderquantity;
    private String orderDate;
    private float billInvoice;
    private String nameshop;

    public AllBillOfShop(String name, int idorder, String nameproduct, int orderquantity, String orderDate, float billInvoice,String nameshop) {
        this.name = name;
        this.idorder = idorder;
        this.nameproduct = nameproduct;
        this.orderquantity = orderquantity;
        this.orderDate = orderDate;
        this.billInvoice = billInvoice;
        this.nameshop = nameshop;
    }
}
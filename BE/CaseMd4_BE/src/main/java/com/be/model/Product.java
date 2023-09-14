package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Lob
    private String describes;
    private String status;
    private float price;
    private int quantity;
    @OneToOne
    private ImgProduct imgProduct;

    @ManyToOne
    private Category category;

    @OneToOne
    private Shop shop;

}

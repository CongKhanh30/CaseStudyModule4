package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class ProductLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Account account;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "likedDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date likedDate;
    public ProductLike(Product product, Account account, Date likedDate) {
        this.product = product;
        this.account = account;
        this.likedDate = likedDate;
    }

    public ProductLike(int id, Product product, Account account, Date likedDate) {
        this.id = id;
        this.product = product;
        this.account = account;
        this.likedDate = likedDate;
    }

    public ProductLike() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Date likedDate) {
        this.likedDate = likedDate;
    }
}
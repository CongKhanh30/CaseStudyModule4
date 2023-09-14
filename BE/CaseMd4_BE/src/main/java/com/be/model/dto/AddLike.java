package com.be.model.dto;

public class AddLike {
    private int idProduct;
    private int idAccount;

    public AddLike(int idProduct, int idAccount) {
        this.idProduct = idProduct;
        this.idAccount = idAccount;
    }

    public AddLike() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
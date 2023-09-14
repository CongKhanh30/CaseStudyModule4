package com.be.service;


import com.be.model.ImgProduct;

import java.util.List;

public interface IImgProductService {
    void save(ImgProduct imgProduct);
    void delete(int id);
    List<ImgProduct> getAll();
}

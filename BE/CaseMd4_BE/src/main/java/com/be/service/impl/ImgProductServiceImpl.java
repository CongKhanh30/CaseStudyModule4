package com.be.service.impl;


import com.be.model.ImgProduct;
import com.be.repository.IImgProductRepo;
import com.be.service.IImgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgProductServiceImpl implements IImgProductService {
    @Autowired
    IImgProductRepo iImgProductRepo;
    @Override
    public void save(ImgProduct imgProduct) {
        iImgProductRepo.save(imgProduct);
    }

    @Override
    public void delete(int id) {
       iImgProductRepo.deleteById(id);
    }

    @Override
    public List<ImgProduct> getAll() {
        return (List<ImgProduct>) iImgProductRepo.findAll();
    }
}

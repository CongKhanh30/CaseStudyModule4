package com.be.controller;

import com.be.model.ImgProduct;
import com.be.service.IImgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ImgProductController {
    @Autowired
    IImgProductService iImgProductService;
    @GetMapping("/imgProduct")
    public ResponseEntity<List<ImgProduct>> getAll() {
        List<ImgProduct> imgProducts = iImgProductService.getAll();
        if (imgProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(imgProducts, HttpStatus.OK);
    }
}

package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ImgProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String thumbnail;
    @Lob
    private String img1;
    @Lob
    private String img2;
    @Lob
    private String img3;
}

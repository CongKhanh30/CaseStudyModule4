package com.be.service;


import com.be.model.Account;
import com.be.model.Category;

import java.util.List;

public interface ICategoryService {
    void save(Category category);
    void delete(int id);
    List<Category> getAll();
}

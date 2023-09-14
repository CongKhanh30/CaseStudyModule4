package com.be.service.impl;


import com.be.model.Category;
import com.be.repository.ICategoryRepo;
import com.be.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Override
    public void save(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
       iCategoryRepo.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }
}

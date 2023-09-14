package com.be.service.impl;

import com.be.model.Comment;
import com.be.repository.ICommentRepo;
import com.be.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepo iCommentRepo;

    @Override
    public Comment findByContent(String content) {
        return iCommentRepo.findByContent(content);
    }

    @Override
    public Comment save(Comment comment) {
        return iCommentRepo.save(comment);
    }

    @Override
    public void delete(int id) {
        iCommentRepo.deleteById(id);
    }

    @Override
    public List<Comment> getAll() {
        return iCommentRepo.findAll();
    }

    @Override
    public List<Comment> findByProductId(int productId) {
        return iCommentRepo.findAllByProductId(productId);
    }
}